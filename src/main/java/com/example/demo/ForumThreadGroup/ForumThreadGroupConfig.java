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
                    "Aktualności",
                    "Najnowsze zmiany",
                    2
            );
            ForumThreadGroup group4 = new ForumThreadGroup(
                    4,
                    "Regulamin",
                    "Regulamin tego forum",
                    2
            );
            ForumThreadGroup group5 = new ForumThreadGroup(
                    5,
                    "Zmiany na forum",
                    "sprawy dotyczące forum",
                    2
            );
            ForumThreadGroup group6 = new ForumThreadGroup(
                    6,
                    "Dla użytkowników",
                    "Część przeznaczona dla użytkowników"
            );
            ForumThreadGroup group7 = new ForumThreadGroup(
                    7,
                    "Główne",
                    "",
                    6
            );
            ForumThreadGroup group8 = new ForumThreadGroup(
                    8,
                    "Zgłaszanie błędów",
                    "",
                    7
            );
            ForumThreadGroup group9 = new ForumThreadGroup(
                    9,
                    "Sugestie zmian",
                    "",
                    7
            );
            ForumThreadGroup group10 = new ForumThreadGroup(
                    10,
                    "Prośba o pomoc",
                    "",
                    7
            );
            ForumThreadGroup group11 = new ForumThreadGroup(
                    11,
                    "Poradniki",
                    "",
                    7
            );
            ForumThreadGroup group12 = new ForumThreadGroup(
                    12,
                    "Inne",
                    "",
                    6
            );
            ForumThreadGroup group13 = new ForumThreadGroup(
                    13,
                    "Gry słowne",
                    "",
                    12
            );
            ForumThreadGroup group14 = new ForumThreadGroup(
                    14,
                    "Dział artystyczny",
                    "",
                    12
            );
            ForumThreadGroup group15 = new ForumThreadGroup(
                    15,
                    "Luźne tematy",
                    "",
                    12
            );
            List<ForumThreadGroup> groupArray = List.of(group1, group2, group3, group4, group5, group6,
                    group7, group8, group9, group10, group11, group12, group13, group14, group15);
            repository.saveAll(groupArray);
        };
    }
}
