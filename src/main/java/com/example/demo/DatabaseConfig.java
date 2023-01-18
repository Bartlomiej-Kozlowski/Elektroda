package com.example.demo;

import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfig {
    public static List<ForumPost> postList = List.of(
            new ForumPost(
                    1,
                    1,
                    1,
                    "Temat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję pierwszy post"
            ),
            new ForumPost(
                    2,
                    2,
                    1,
                    "2Temat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję drugi post"
            ),
            new ForumPost(
                    3,
                    1,
                    1,
                    "2Tem2at",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję trzeci post"
            ),
            new ForumPost(
                    4,
                    2,
                    2,
                    "2Te4mat",
                    "Dzień dobry drodzy forumowicze. Tutaj testuję inny post"
            ));
    @Bean
    CommandLineRunner forumPostCommandLineRunner(ForumPostRepository repository){
        return args -> {
            List<ForumPost> groupArray = postList;
            repository.saveAll(groupArray);
        };
    };
}
