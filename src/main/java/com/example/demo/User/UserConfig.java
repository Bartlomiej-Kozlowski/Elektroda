package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class UserConfig {
//    UserRepository userRepository;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User user1 = new User(
                    "testUser",
                    "user@gmail"
            );
            repository.save(user1);
        };
    }

//    @Autowired
//    public UserConfig()
}
