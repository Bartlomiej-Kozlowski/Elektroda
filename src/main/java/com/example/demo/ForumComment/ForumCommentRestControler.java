package com.example.demo.ForumComment;

import com.example.demo.ForumComment.ForumComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/forumComment")
public class ForumCommentRestControler {
    private ForumCommentService forumCommentService;

    @Autowired
    public ForumCommentRestControler(ForumCommentService forumCommentService){
        this.forumCommentService = forumCommentService;
    }
    @PostMapping("/list")
    public List<ForumComment> getForumComment(@RequestBody ForumCommentListRequestDTO forumComment) {
        return forumCommentService.getForumComments(forumComment);
    }
    @PostMapping("/add")
    public boolean addForumComment(@RequestBody ForumCommentAddRequestDTO forumComment) {
        return forumCommentService.addForumComment(forumComment);
    }

}

