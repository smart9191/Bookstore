package uz.bookstore.service;


import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import uz.bookstore.entity.Book;
import uz.bookstore.entity.User;
import uz.bookstore.entity.UserPurchase;
import uz.bookstore.repository.BookRepository;
import uz.bookstore.repository.UserPurchaseRepository;
import uz.bookstore.repository.UserRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserPurchaseService {


    private final UserPurchaseRepository userPurchaseRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public void saveUserPurchase(Long id, Authentication authentication) {
        try {
            UserPurchase userPurchase = new UserPurchase();
            User user = userRepository.findByUserName(authentication.getName());
            Book book = bookRepository.findById(id).orElse(null);
//            assert book != null;
            userPurchase.setBook(book);
            userPurchase.setUser(user);
            userPurchase.setPrice(book.getPrice());
            userPurchaseRepository.save(userPurchase);
        }
        catch (NullPointerException e){
            System.out.println("Book not found");
        }
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

    public void fakerUserPurchase(){
        for (int i = 0; i < 500; i++) {
            UserPurchase userPurchase = new UserPurchase();
            Book book = bookRepository.findById((long) getNumBook()).orElse(null);
            userPurchase.setPrice(book.getPrice());
            userPurchase.setUser(userRepository.findById((long) getNum()).orElse(null));
            userPurchase.setBook(book);
            userPurchaseRepository.save(userPurchase);
        }
    }

    public UserPurchase updateUserPurchase(UserPurchase userPurchase){
        return userPurchaseRepository.save(userPurchase);
    }

    public void deleteUserPurchase(Long id){
        userPurchaseRepository.deleteById(id);
    }

    public List<UserPurchase> getUserPurchases(){
        return userPurchaseRepository.findAll();
    }

}
