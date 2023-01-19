package com.example.demo;

import com.example.demo.ForumComment.ForumComment;
import com.example.demo.ForumComment.ForumCommentRepository;
import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import com.example.demo.User.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DatabaseConfig {
    PasswordEncoder passwordEncoder;
    public List<User> userConfigList;
    public List<ForumPost> postConfigList;
    public List<ForumComment> commentConfigList;

    @Autowired
    public DatabaseConfig(PasswordEncoder passwordEncoder){
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
        postConfigList = List.of(
                new ForumPost(
                        1,
                        userConfigList.get(0),
                        1,
                        "Temat",
                        "Dzień dobry drodzy forumowicze. Tutaj testuję pierwszy post"
                ),
                new ForumPost(
                        2,
                        userConfigList.get(1),
                        1,
                        "2Temat",
                        "Dzień dobry drodzy forumowicze. Tutaj testuję drugi post"
                ),
                new ForumPost(
                        3,
                        userConfigList.get(0),
                        1,
                        "2Tem2at",
                        "Dzień dobry drodzy forumowicze. Tutaj testuję trzeci post"
                ),
                new ForumPost(
                        4,
                        userConfigList.get(1),
                        2,
                        "2Te4mat",
                        "Dzień dobry drodzy forumowicze. Tutaj testuję inny post"
                )
        );
        commentConfigList = List.of(
            new ForumComment(
                1,
                userConfigList.get(0),
                "Komentarz1",
                postConfigList.get(0)
            ),
            new ForumComment(
                2,
                userConfigList.get(0),
                "Jestem Komentarzem",
                postConfigList.get(0)
            ),
            new ForumComment(
                    3,
                    userConfigList.get(1),
                    "Jestem Komentarzem",
                    postConfigList.get(0)
            ),
            new ForumComment(
                    4,
                    userConfigList.get(1),
                    "Jestem Komentarzem",
                    postConfigList.get(1)
            )
        );
    }

    @Bean
    CommandLineRunner forumPostCommandLineRunner(ForumPostRepository postRepository,
                                                 UserRepository userRepository,
                                                 ForumCommentRepository commentRepository){
        return args -> {
            userRepository.saveAll(userConfigList);
            postRepository.saveAll(postConfigList);
            commentRepository.saveAll(commentConfigList);
        };
    };
}
