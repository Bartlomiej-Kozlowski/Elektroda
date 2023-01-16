package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestControler {
    private UserService userService;

    @Autowired
    public UserRestControler(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/get")    //get sensitive data
    public List<User> getUser() {
        return userService.getUsers();
    }

    @PostMapping("/getProfile")    //get insensitive data that all people can see
    public UserProfile getUserProfile(@RequestBody UserProfileRequestDTO userProfile) {
        return userService.getUserProfile(userProfile);
//        List<User> userList = userService.getUsers();
//        model.addAttribute("list", userList);
//        return "dashboard";
    }

}

