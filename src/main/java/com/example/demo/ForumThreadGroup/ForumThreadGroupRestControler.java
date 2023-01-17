package com.example.demo.ForumThreadGroup;

import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ForumThreadGroupRestControler {
    private ForumThreadGroupService forumThreadGroupService;

    @Autowired
    public ForumThreadGroupRestControler(ForumThreadGroupService forumThreadGroupService){
        this.forumThreadGroupService = forumThreadGroupService;
    }
    @GetMapping("/forum")
    public String getForumThreadGroup(Model model) {
        List<ForumThreadGroup> list = forumThreadGroupService.getForumThreadGroups();
        model.addAttribute("GroupList", list);
        return "Forum";
    }

}

