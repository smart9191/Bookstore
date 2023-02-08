package uz.bookstore.webRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookstore.entity.User;
import uz.bookstore.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody User user){
        if (!checkPasswordLength(user.getPassword())){

            return new ResponseEntity<>("Parol uzuligi 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity<>("Bu user oldin ro'yxatdan o'tgan", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    private Boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }

    @PostMapping("/register/faker")
    public ResponseEntity<?> fakerUser(){
        userService.fakerUser();
        return new ResponseEntity<>("Faker userlar yaratildi", HttpStatus.CREATED);
    }



}
