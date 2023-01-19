package com.example.demo.User;

public record UserProfileRequestDTO(Integer id) {
    public UserProfileRequestDTO(Integer id) {
        this.id = id;
    }
}
