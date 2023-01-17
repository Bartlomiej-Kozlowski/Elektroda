package com.example.demo.AuthToken;
import java.io.Serializable;

public record JwtRequest(String username, String password){
}