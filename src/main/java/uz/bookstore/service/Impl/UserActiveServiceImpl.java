package uz.bookstore.service.Impl;

import org.springframework.stereotype.Service;
import uz.bookstore.dto.UserActiveDto;
import uz.bookstore.repository.UserActiveDao;
import uz.bookstore.service.UserActiveService;

import java.util.List;

@Service
public class UserActiveServiceImpl implements UserActiveService {

    private final UserActiveDao userActiveDao;

    public UserActiveServiceImpl(UserActiveDao userActiveDao) {
        this.userActiveDao = userActiveDao;
    }
    @Override
    public List<UserActiveDto> getUserActive() {
        return userActiveDao.getUserActive();
    }
}
