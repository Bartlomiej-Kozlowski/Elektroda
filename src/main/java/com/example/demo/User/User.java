package com.example.demo.User;

import javax.persistence.*;

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

    public User(String name, String email){
        this.name = name;
        this.email = email;
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
}
