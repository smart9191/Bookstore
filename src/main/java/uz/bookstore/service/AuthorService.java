package uz.bookstore.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import uz.bookstore.entity.Author;
import uz.bookstore.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public void fakerAuthor() {

        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Author author = new Author();
            author.setName(faker.name().fullName());
            authorRepository.save(author);
        }
    }


}
