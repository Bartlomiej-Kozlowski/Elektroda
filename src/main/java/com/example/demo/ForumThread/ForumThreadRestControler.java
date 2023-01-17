package com.example.demo.ForumThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/forumThread")
public class ForumThreadRestControler {
    private ForumThreadService forumThreadService;

    @Autowired
    public ForumThreadRestControler(ForumThreadService forumThreadService){
        this.forumThreadService = forumThreadService;
    }
    @PostMapping("/get")
    public List<ForumThread> getForumThread() {
        return forumThreadService.getForumThreads();
    }

}

