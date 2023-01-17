package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class UserConfig {
//    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            List<User> users = List.of(
                new User(
                        1,
                        "admin",
                        "admin@gmail",
                        passwordEncoder.encode("admin"),
                        UserRole.ROLE_ADMIN
                ),
                new User(
                    "testUser",
                    "user@gmail",
                            passwordEncoder.encode("haslo"),
                    UserRole.ROLE_USER
                )
            );
            repository.saveAll(users);
        };
    }

//    @Autowired
//    public UserConfig()
}
