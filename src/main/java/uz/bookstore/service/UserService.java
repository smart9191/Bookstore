package uz.bookstore.service;


import com.github.javafaker.Faker;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bookstore.entity.Role;
import uz.bookstore.entity.User;
import uz.bookstore.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User create(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    public Boolean checkUserName(String userName){
        return userRepository.existsByUserName(userName);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


    public Timestamp getRondomDate(){

        LocalDate start = LocalDate.of(2022, 6, 1);
        LocalDate end = LocalDate.of(2023, 2, 8);

        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();

        Random random = new Random();
        long randomDay = startEpochDay + random.nextInt((int) (endEpochDay - startEpochDay));
        return Timestamp.valueOf(LocalDate.ofEpochDay(randomDay).atStartOfDay());
    }

    public void fakerUser() {
        Faker faker = new Faker();
        for (int i = 0; i < 200; i++) {
            Set<Role> role = new HashSet<>();
            role.add(new Role("ROLE_USER"));
            User user = new User();
            user.setUserName(faker.name().username());
            user.setPassword(passwordEncoder.encode(faker.internet().password()));
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setEnabled(true);
            user.setRoles(role);
            user.setCreated_at(getRondomDate());
            userRepository.save(user);
        }
    }

}
