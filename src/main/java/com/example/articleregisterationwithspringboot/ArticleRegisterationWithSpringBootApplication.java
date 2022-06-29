package com.example.articleregisterationwithspringboot;


import com.example.articleregisterationwithspringboot.exception.InValidDataException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleRegisterationWithSpringBootApplication {

    public static void main(String[] args) throws InValidDataException {
        SpringApplication.run(ArticleRegisterationWithSpringBootApplication.class, args);
    }

}
