package com.example.demo.ForumPost;

import com.example.demo.ForumComment.ForumCommentListRequestDTO;
import com.example.demo.ForumComment.ForumCommentService;
import com.example.demo.ForumComment.ForumCommentWithUserData;
import com.example.demo.ForumThread.ForumThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Controller
public class ForumPostControler {
    private ForumThreadService forumThreadService;
    private ForumPostService forumPostService;
    private ForumCommentService forumCommentService;

    @Autowired
    public ForumPostControler(ForumThreadService forumThreadService, ForumPostService forumPostService, ForumCommentService forumCommentService) {
        this.forumThreadService = forumThreadService;
        this.forumPostService = forumPostService;
        this.forumCommentService = forumCommentService;
    }

    @GetMapping("/forum/post/{postId}")
    public String getThread(@CookieValue(name = "authenticationToken", required=false) String token, @PathVariable int postId, Model model){
        ForumPostWithUserData forumPost = forumPostService.getForumPost(token, postId);
        List<ForumCommentWithUserData> forumComments = forumCommentService.getForumComments(token, new ForumCommentListRequestDTO(postId));
        model.addAttribute("post", forumPost);
        model.addAttribute("comments", forumComments);
        return "Post";

    }
}
