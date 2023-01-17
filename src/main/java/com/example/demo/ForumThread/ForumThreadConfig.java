package com.example.demo.ForumThread;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class ForumThreadConfig {

    @Bean
    CommandLineRunner forumThreadCommandLineRunner(ForumThreadRepository repository){
        return args -> {
            ForumThread group1 = new ForumThread(
                    1,
                    "Aktualności",
                    "Najnowsze zmiany",
                    2
            );
            ForumThread group2 = new ForumThread(
                    2,
                    "Regulamin",
                    "Regulamin tego forum",
                    2
            );
            ForumThread group3 = new ForumThread(
                    3,
                    "Zmiany na forum",
                    "sprawy dotyczące forum",
                    2
            );
            ForumThread group4 = new ForumThread(
                    4,
                    "Zgłaszanie błędów",
                    "",
                    4
            );
            ForumThread group5 = new ForumThread(
                    5,
                    "Sugestie zmian",
                    "",
                    4
            );
            ForumThread group6 = new ForumThread(
                    6,
                    "Prośba o pomoc",
                    "",
                    4
            );
            ForumThread group7 = new ForumThread(
                    7,
                    "Poradniki",
                    "",
                    4
            );
            ForumThread group8 = new ForumThread(
                    8,
                    "Gry słowne",
                    "",
                    5
            );
            ForumThread group9 = new ForumThread(
                    9,
                    "Dział artystyczny",
                    "",
                    5
            );
            ForumThread group10 = new ForumThread(
                    10,
                    "Luźne tematy",
                    "",
                    5
            );
            List<ForumThread> groupArray = List.of(group1, group2, group3, group4, group5, group6,
                    group7, group8, group9, group10);
            repository.saveAll(groupArray);
        };
    }
}
