package uz.bookstore.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bookstore.dto.BookDto;
import uz.bookstore.entity.*;
import uz.bookstore.repository.AuthorRepository;
import uz.bookstore.repository.BookRepository;
import uz.bookstore.repository.CategoryRepository;
import uz.bookstore.repository.PriceRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    @Transactional
    public void saveBook(BookDto bookDto) {
        try {
            Book book = new Book();
            Price price = new Price();
            Author author = authorRepository.findById(bookDto.getAuthorId()).orElse((null));
            Category category = categoryRepository.findById(bookDto.getCategoryId()).orElse((null));
            book.setTitle(bookDto.getTitle());
            book.setPublicationYear(bookDto.getPublicationYear());
            book.setPrice(Double.valueOf(bookDto.getPrice()));
            book.setAuthor(author);
            book.setCategory(category);
            Book book1 = bookRepository.save(book);
            price.setBook(book1);
            price.setPrice(Double.valueOf(bookDto.getPrice()));
            priceRepository.save(price);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public int getNum(){
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        return num;
    }

    public int getNumSmall(){
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        return number;
    }

    public Double getPrice(){
        Random random = new Random();
        double price = random.nextInt((50000-10000)+1)+10000;
        return price;
    }

    @Transactional
    public void fakerBook(){
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            UserPurchase userPurchase = new UserPurchase();
            Book book = new Book();
            Price price = new Price();
            book.setAuthor(authorRepository.findById((long) getNum()).orElse(null));
              book.setCategory(categoryRepository.findById((long) getNumSmall()).orElse(null));
              book.setTitle(faker.book().title());
              book.setPublicationYear(String.valueOf(faker.number().numberBetween(2000, 2021)));
              book.setPrice(getPrice());
              Book book1 = bookRepository.save(book);
              price.setPrice(book1.getPrice());
              price.setBook(book1);
              priceRepository.save(price);
        }

    }

}
