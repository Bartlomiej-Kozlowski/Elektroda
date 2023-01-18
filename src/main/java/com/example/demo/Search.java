package com.example.demo;

import com.example.demo.ForumThread.ForumThread;
import com.example.demo.ForumThread.ForumThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Search {
    private ForumThreadService forumThreadService;

    @Autowired
    public Search(ForumThreadService forumThreadService){
        this.forumThreadService = forumThreadService;
    }
    @GetMapping("/search")
    public String search(@RequestParam(name="search", required = false, defaultValue = "world") String search, Model model){
        List<ForumThread> szukaj=forumThreadService.search(search);
        model.addAttribute("search", szukaj);
        return "Search";
    }

}
