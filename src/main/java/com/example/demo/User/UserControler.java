package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
