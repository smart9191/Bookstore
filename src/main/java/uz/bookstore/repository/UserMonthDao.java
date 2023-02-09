package uz.bookstore.repository;

import uz.bookstore.dto.UserMonthDto;

import java.util.List;

public interface UserMonthDao {

    List<UserMonthDto> getUserMonth();

}
