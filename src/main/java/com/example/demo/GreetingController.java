package com.example.demo;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
	private final UserService userService;

	@Autowired
	public GreetingController(UserService userService){
		this.userService = userService;
	}

	@GetMapping("/dashboard")
	public String dashboard(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
		model.addAttribute("name", name);
		return "dashboard";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required=false, defaultValue="world") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";

	}
}
