package uz.bookstore.service.Impl;

import org.springframework.stereotype.Service;
import uz.bookstore.dto.UserMonthDto;
import uz.bookstore.repository.UserMonthDao;
import uz.bookstore.service.UserMonthService;

import java.util.List;
@Service
public class UserMonthServiceImpl implements UserMonthService {

    private final UserMonthDao userMonthDao;

    public UserMonthServiceImpl(UserMonthDao userMonthDao) {
        this.userMonthDao = userMonthDao;
    }

    @Override
    public List<UserMonthDto> getUserMonth() {
        return  userMonthDao.getUserMonth();
    }
}
