package uz.bookstore.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import uz.bookstore.dto.CommentDto;
import uz.bookstore.entity.Book;
import uz.bookstore.entity.Comment;
import uz.bookstore.entity.User;
import uz.bookstore.repository.BookRepository;
import uz.bookstore.repository.CommentRepository;
import uz.bookstore.repository.UserRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public void saveComment(CommentDto commentDto, Authentication authentication) {
        Comment comment = new Comment();
        Book book = bookRepository.findById(commentDto.getBookId()).orElse(null);
        User user = userRepository.findByUserName(authentication.getName());
        comment.setContent(commentDto.getContent());
        assert book != null;
        comment.setBook(book);
        comment.setUser(user);
        commentRepository.save(comment);
    }

    public int getNum(){
        Random random = new Random();
        int num = random.nextInt(200) + 1;
        return num;
    }

    public int getNumBook(){
        Random random = new Random();
        int nums = random.nextInt(100) + 1;
        return nums;
    }

    public void fakerComment() {
        Faker faker = new Faker();
        for (int i = 0; i < 2000; i++) {
            Comment comment = new Comment();
            comment.setUser(userRepository.findById((long) getNum()).orElse(null));
            comment.setBook(bookRepository.findById((long) getNumBook()).orElse(null));
            comment.setContent(faker.book().title());
            commentRepository.save(comment);
        }
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }




}
