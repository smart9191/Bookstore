package uz.bookstore.webRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookstore.service.AuthorService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("save")
    public ResponseEntity saveAuthor() {
        authorService.fakerAuthor();
       return ResponseEntity.ok("Ma'lumotlar yaratildi");
    }
    @GetMapping ("all")
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }



}
