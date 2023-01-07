package com.example.demo;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import com.example.demo.userToken.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GreetingController {
	private final AuthenticationService authenticationService;
	private final UserService userService;

	@Autowired
	public GreetingController(AuthenticationService authenticationService, UserService userService){
		this.authenticationService = authenticationService;
		this.userService = userService;
	}

	@GetMapping("/dashboard")
	public String dashboard(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
		model.addAttribute("name", name);
//		List<User> userList = userService.getUsers();
//		model.addAttribute("list", userList);
		return "dashboard";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";

	}


	/*
	@GetMapping("/getToken")
	public int authenticate(){
		return authenticationService.getToken();
	}*/
//	@GetMapping("/gra")
//	public String greeting(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
//		/*model.addAttribute("name", name);*/
//		int[] a = {0, 0, 1};
//		model.addAttribute("test", a);
//
//		return a.toString();
//	}

//	@GetMapping("/")
//	public String greeting2(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//
//	}
}
