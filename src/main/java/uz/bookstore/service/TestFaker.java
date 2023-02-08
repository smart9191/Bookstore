package uz.bookstore.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class TestFaker {

    Faker faker = new Faker();

    public String getFakerName(){
        return faker.name().fullName();
    }

    public String getFakerAddress(){
        return faker.address().fullAddress();
    }

}
