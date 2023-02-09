package uz.bookstore.repository;

import org.springframework.stereotype.Repository;
import uz.bookstore.dto.UserActiveDto;

import java.util.List;

public interface UserActiveDao {

    List<UserActiveDto> getUserActive();


}
