package com.example.demo.User;

public class UserProfileData {
    Integer id;
    String name;

    public UserProfileData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
