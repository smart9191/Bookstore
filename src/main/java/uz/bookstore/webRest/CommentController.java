package uz.bookstore.webRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.bookstore.dto.CommentDto;
import uz.bookstore.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody CommentDto commentDto, Authentication authentication){
       commentService.saveComment(commentDto,authentication);
        return new ResponseEntity<>("Comment added", HttpStatus.OK);
    }


    @PostMapping("/add/faker")
    public ResponseEntity<?> fakerComment(){
        commentService.fakerComment();
        return new ResponseEntity<>("Faker commentlar yaratildi", HttpStatus.CREATED);
    }

}
