package com.example.demo.ForumThread;

import com.example.demo.ForumPost.ForumPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ForumThreadRestControler {
    private ForumThreadService forumThreadService;

    @Autowired
    public ForumThreadRestControler(ForumThreadService forumThreadService){
        this.forumThreadService = forumThreadService;
    }
    @GetMapping("/forum/{groupId}")
    public String getForumThread(@PathVariable String groupId, Model model) {
        int id = Integer.parseInt(groupId);
        List<ForumThread> list =  forumThreadService.getForumThreads(id);
        model.addAttribute("threads", list);
        model.addAttribute("groupId", id);
        return "Group";
    }
    @GetMapping("/forum/all")
    public String getAllForumThreads(Model model){
        List<ForumThread> list = forumThreadService.getForumThreads();
        model.addAttribute("threads", list);
        return "Group";
    }
    @GetMapping("/forum/{groupId}/{threadId}")
    public String getThread(@PathVariable int groupId,@PathVariable int threadId, Model model){
        ForumThread thread = forumThreadService.getThread(threadId);
        List<ForumPost> list = forumThreadService.getForumPost(threadId);
        model.addAttribute("thread", thread);
        model.addAttribute("posts", list);
        return "Postlist";
//        return "Post";

    }

}

