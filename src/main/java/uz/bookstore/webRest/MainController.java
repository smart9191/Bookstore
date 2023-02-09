package uz.bookstore.webRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookstore.dto.UserActiveDto;
import uz.bookstore.dto.UserMonthDto;
import uz.bookstore.dto.UsersWeekDto;
import uz.bookstore.service.UserMonthService;
import uz.bookstore.service.UsersWeekDtoService;
import uz.bookstore.service.UserActiveService;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final UsersWeekDtoService usersWeekDtoService;
    private final UserActiveService userActiveDtoService;
    private final UserMonthService userMonthService;

    @GetMapping( "/users-week")
    public ResponseEntity<List<UsersWeekDto>> getUsersWeek() {
        List<UsersWeekDto> usersWeek = usersWeekDtoService.getUsersWeek();
        return ResponseEntity.ok(usersWeek);

    }
    @GetMapping("/users-active")
    public ResponseEntity<List<UserActiveDto>> getUsersActive() {
        List<UserActiveDto> userActiveDtoList = userActiveDtoService.getUserActive();
        return ResponseEntity.ok(userActiveDtoList);
    }
    @GetMapping("/users-month")
    public ResponseEntity<List<UserMonthDto>> getUsersMonth() {
        List<UserMonthDto> userMonth = userMonthService.getUserMonth();
        return ResponseEntity.ok(userMonth);
    }

}
