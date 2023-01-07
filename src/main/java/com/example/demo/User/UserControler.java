package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserControler {
    private UserService userService;

    @Autowired
    public UserControler(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerNewUser(@RequestBody User user){
        userService.addUser(user);
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
