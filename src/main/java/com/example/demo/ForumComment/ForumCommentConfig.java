package com.example.demo.ForumComment;

import com.example.demo.ForumComment.ForumComment;
import com.example.demo.ForumComment.ForumCommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//tutaj domyślne wartości dla bazy danych.
@Configuration
public class ForumCommentConfig {

    @Bean
    CommandLineRunner forumCommentCommandLineRunner(ForumCommentRepository repository){
        return args -> {
            ForumComment group1 = new ForumComment(
                    1,
                    1,
                    1,
                    "Komentarz1"
            );
            ForumComment group2 = new ForumComment(
                    2,
                    1,
                    1,
                    "Jestem Komentarzem"
            );/*
            ForumComment group3 = new ForumComment(
                    3,
                    "Zmiany na forum",
                    "sprawy dotyczące forum",
                    2
            );
            ForumComment group4 = new ForumComment(
                    4,
                    "Zgłaszanie błędów",
                    "",
                    4
            );
            ForumComment group5 = new ForumComment(
                    5,
                    "Sugestie zmian",
                    "",
                    4
            );
            ForumComment group6 = new ForumComment(
                    6,
                    "Prośba o pomoc",
                    "",
                    4
            );
            ForumComment group7 = new ForumComment(
                    7,
                    "Poradniki",
                    "",
                    4
            );
            ForumComment group8 = new ForumComment(
                    8,
                    "Gry słowne",
                    "",
                    5
            );
            ForumComment group9 = new ForumComment(
                    9,
                    "Dział artystyczny",
                    "",
                    5
            );
            ForumComment group10 = new ForumComment(
                    10,
                    "Luźne tematy",
                    "",
                    5
            );*/
            List<ForumComment> groupArray = List.of(group1, group2/*, group3, group4, group5, group6,
                    group7, group8, group9, group10*/);
            repository.saveAll(groupArray);
        };
    }
}
