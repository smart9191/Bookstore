package uz.bookstore.service.Impl;

import org.springframework.stereotype.Service;
import uz.bookstore.dto.UsersWeekDto;
import uz.bookstore.repository.UsersWeekDao;
import uz.bookstore.service.UsersWeekDtoService;

import java.util.List;

@Service
public class UsersWeekDtoImpl implements UsersWeekDtoService {

    private final UsersWeekDao usersWeekDao;

    public UsersWeekDtoImpl(UsersWeekDao usersWeekDao) {
        this.usersWeekDao = usersWeekDao;
    }
    @Override
    public List<UsersWeekDto> getUsersWeek() {
        return usersWeekDao.getUsersWeek();
    }
}
