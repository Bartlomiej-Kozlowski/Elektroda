package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestControler {
    private UserService userService;

    @Autowired
    public UserRestControler(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/get")
    public List<User> getUser(Model model) {
        return userService.getUsers();
//        List<User> userList = userService.getUsers();
//        model.addAttribute("list", userList);
//        return "dashboard";
    }

}

