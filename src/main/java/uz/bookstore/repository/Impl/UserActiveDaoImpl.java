package uz.bookstore.repository.Impl;

import org.springframework.stereotype.Repository;
import uz.bookstore.dto.UserActiveDto;
import uz.bookstore.repository.UserActiveDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserActiveDaoImpl implements UserActiveDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserActiveDto> getUserActive() {
        List<UserActiveDto> userActiveDtoList = new ArrayList<>();


        String sql =  "SELECT users.first_name AS user_name,\n" +
                "    COUNT(user_purchase.book_id) AS total_books_purchased,\n" +
                "    SUM(book.price) AS total_purchase_amount,\n" +
                "    COUNT(comment.id) AS total_comments\n" +
                "FROM\n" +
                "    users\n" +
                "        LEFT JOIN user_purchase ON users.id = user_purchase.user_id\n" +
                "        LEFT JOIN book ON user_purchase.book_id = book.id\n" +
                "        LEFT JOIN comment ON users.id = comment.user_id\n" +
                "GROUP BY\n" +
                "     users.first_name\n" +
                "ORDER BY\n" +
                "    COUNT(user_purchase.book_id) DESC,\n" +
                "    SUM(book.price) DESC,\n" +
                "    COUNT(comment.id) DESC";

        try {
            Query query = entityManager.createNativeQuery(sql, UserActiveDto.class);
            userActiveDtoList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
            return userActiveDtoList;
        }

}