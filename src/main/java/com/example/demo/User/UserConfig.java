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
    PasswordEncoder passwordEncoder;
    public List<User> userConfigList;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userConfigList = List.of(
                new User(
                        1,
                        "admin",
                        "admin@gmail",
                        passwordEncoder.encode("admin"),
                        UserRole.ROLE_ADMIN
                ),
                new User(
                        2,
                        "uzytkownik",
                        "user@gmail",
                        passwordEncoder.encode("haslo"),
                        UserRole.ROLE_USER
                ),
                new User(
                        3,
                        "testUser",
                        "user2@gmail",
                        passwordEncoder.encode("haslo"),
                        UserRole.ROLE_USER
                )
        );
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            repository.saveAll(userConfigList);
        };
    }

//    @Autowired
//    public UserConfig()
}
