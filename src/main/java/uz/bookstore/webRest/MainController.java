package uz.bookstore.webRest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookstore.dto.UsersWeekDto;
import uz.bookstore.service.UsersWeekDtoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UsersWeekDtoService usersWeekDtoService;

    public MainController(UsersWeekDtoService usersWeekDtoService) {
        this.usersWeekDtoService = usersWeekDtoService;
    }
    @GetMapping(value = "/users-week")
    public ResponseEntity<List<UsersWeekDto>> getUsersWeek() {
        List<UsersWeekDto> usersWeek = usersWeekDtoService.getUsersWeek();
        return ResponseEntity.ok(usersWeek);

    }

}
