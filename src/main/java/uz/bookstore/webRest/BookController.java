package uz.bookstore.webRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookstore.dto.BookDto;
import uz.bookstore.service.BookService;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
        return new ResponseEntity<>("Book added", HttpStatus.OK);
    }


    @PostMapping("/add/faker")
    public ResponseEntity<?> fakerBook(){
        bookService.fakerBook();
        return new ResponseEntity<>("Faker booklar yaratildi", HttpStatus.CREATED);
    }


}
