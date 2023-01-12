package com.example.demo.ForumThreadGroup;

import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/forumThreadGroup")
public class ForumThreadGroupRestControler {
    private ForumThreadGroupService forumThreadGroupService;

    @Autowired
    public ForumThreadGroupRestControler(ForumThreadGroupService forumThreadGroupService){
        this.forumThreadGroupService = forumThreadGroupService;
    }
    @PostMapping("/get")
    public List<ForumThreadGroup> getForumThreadGroup() {
        return forumThreadGroupService.getForumThreadGroups();
    }

}

