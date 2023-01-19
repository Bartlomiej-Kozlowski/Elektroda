package com.example.demo.User;

import com.example.demo.ForumPost.ForumPost;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//model obiektu użytkownika
@Entity // This tells Hibernate to make a table out of this class
@Table  // Mówi bazie danych, żeby utworzyła taką tabelę.
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    @OneToMany(mappedBy="user")
    private List<ForumPost> posts;

    public User(int id, String name, String email, String password, UserRole role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.posts = new ArrayList<ForumPost>();
    }
    public User(String name, String email, String password, UserRole role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.posts = new ArrayList<ForumPost>();
    }
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
//        this.role = List.of(UserRole.ROLE_USER);
        this.role = UserRole.ROLE_USER;
        this.posts = new ArrayList<ForumPost>();
    }

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<ForumPost> getPosts() {
        return posts;
    }
}
