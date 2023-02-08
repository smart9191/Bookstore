package uz.bookstore.repository.Impl;

import org.springframework.stereotype.Repository;
import uz.bookstore.dto.UsersWeekDto;
import uz.bookstore.repository.UsersWeekDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersWeekDaoImpl implements UsersWeekDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsersWeekDto> getUsersWeek() {
        List<UsersWeekDto> usersWeekDtoList = new ArrayList<>();

        String sql = "select * from users " +
                "where created_at >= now()-interval '1 week'";

        try {
            Query query = entityManager.createNativeQuery(sql, UsersWeekDto.class);
            usersWeekDtoList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return usersWeekDtoList;
    }

}
