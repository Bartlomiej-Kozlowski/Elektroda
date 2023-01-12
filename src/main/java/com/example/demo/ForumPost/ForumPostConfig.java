package com.example.demo.ForumPost;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class ForumPostConfig {

    @Bean
    CommandLineRunner forumPostCommandLineRunner(ForumPostRepository repository){
        return args -> {
            ForumPost group1 = new ForumPost(
                    1,
                    1,
                    1,
                    "Temat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję pierwszy post"
            );
            ForumPost group2 = new ForumPost(
                    2,
                    1,
                    1,
                    "2Temat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję drugi post"
            );
            ForumPost group3 = new ForumPost(
                    3,
                    1,
                    1,
                    "2Tem2at",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję trzeci post"
            );
            ForumPost group4 = new ForumPost(
                    4,
                    1,
                    2,
                    "2Te4mat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję inny post"
            );
            List<ForumPost> groupArray = List.of(group1, group2, group3, group4/*, group5, group6,
                    group7, group8, group9, group10*/);
            repository.saveAll(groupArray);
        };
    }
}
