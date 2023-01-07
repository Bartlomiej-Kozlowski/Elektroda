package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserControler {
    private UserService userService;

    @Autowired
    public UserControler(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }
    @PostMapping("/register")
    public String registerNewUser(User user){
        userService.addUser(user);
        return "register_success";
    }
//    @GetMapping("/get")
    @PostMapping("/get")
    public List<User> getUser(Model model) {
        return userService.getUsers();
//        List<User> userList = userService.getUsers();
//        model.addAttribute("list", userList);
//        return "dashboard";
    }

}
