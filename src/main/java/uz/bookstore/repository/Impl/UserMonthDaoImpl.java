package uz.bookstore.repository.Impl;

import org.springframework.stereotype.Repository;
import uz.bookstore.dto.UserMonthDto;
import uz.bookstore.repository.UserMonthDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMonthDaoImpl implements UserMonthDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserMonthDto> getUserMonth() {
        List<UserMonthDto> userMonthDtoList = new ArrayList<>();

        String sql = "select\n" +
                "    extract(month from created_at) as month,\n" +
                "    count(*) as total_users\n" +
                "    from users\n" +
                "    group by month\n" +
                "    order by month";

        try {
            Query query = entityManager.createNativeQuery(sql, UserMonthDto.class);
            userMonthDtoList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return userMonthDtoList;
    }
}
