package com.example.demo.ForumThreadGroup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class ForumThreadGroupConfig {

    @Bean
    CommandLineRunner forumThreadGroupCommandLineRunner(ForumThreadGroupRepository repository){
        return args -> {
            ForumThreadGroup group1 = new ForumThreadGroup(
                    1,
                    "Dla administratorów",
                    "Sprawy Administracyjne"
            );
            ForumThreadGroup group2 = new ForumThreadGroup(
                    2,
                    "Główne",
                    "",
                    1
            );
            ForumThreadGroup group3 = new ForumThreadGroup(
                    3,
                    "Dla użytkowników",
                    "Część przeznaczona dla użytkowników"
            );
            ForumThreadGroup group4 = new ForumThreadGroup(
                    4,
                    "Główne",
                    "",
                    3
            );
            ForumThreadGroup group5 = new ForumThreadGroup(
                    5,
                    "Inne",
                    "",
                    3
            );
            List<ForumThreadGroup> groupArray = List.of(group1, group2, group3, group4, group5);
            repository.saveAll(groupArray);
        };
    }
}
