package uz.bookstore.webRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookstore.service.UserPurchaseService;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class UserPurchaseController {

    private final UserPurchaseService userPurchaseService;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addUserPurchase(@PathVariable Long id, Authentication authentication){
        userPurchaseService.saveUserPurchase(id, authentication);
        return new ResponseEntity<>("User purchase added", HttpStatus.OK);
    }

    @PostMapping("/add/faker")
    public ResponseEntity<?> fakerUserPurchase(){
        userPurchaseService.fakerUserPurchase();
        return new ResponseEntity<>("Faker user purchase added", HttpStatus.CREATED);
    }

}
