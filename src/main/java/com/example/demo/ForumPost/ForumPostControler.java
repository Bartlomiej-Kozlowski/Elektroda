package com.example.demo.ForumPost;

import com.example.demo.ForumComment.ForumCommentListRequestDTO;
import com.example.demo.ForumComment.ForumCommentService;
import com.example.demo.ForumComment.ForumCommentWithUserData;
import com.example.demo.ForumThread.ForumThreadService;
import com.example.demo.User.UserProfile;
import com.example.demo.User.UserProfileData;
import com.example.demo.User.UserProfileRequestDTO;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ForumPostControler {
    private ForumThreadService forumThreadService;
    private ForumPostService forumPostService;
    private ForumCommentService forumCommentService;
    private UserService userService;

    @Autowired
    public ForumPostControler(ForumThreadService forumThreadService, ForumPostService forumPostService, ForumCommentService forumCommentService, UserService userService) {
        this.forumThreadService = forumThreadService;
        this.forumPostService = forumPostService;
        this.forumCommentService = forumCommentService;
        this.userService = userService;
    }

    @GetMapping("/forum/post/{postId}")
    public String getThread(@CookieValue(name = "authenticationToken", required=false) String token, @PathVariable int postId, Model model){
        ForumPostWithUserData forumPost = forumPostService.getForumPost(token, postId);
        List<ForumCommentWithUserData> forumComments = forumCommentService.getForumComments(token, new ForumCommentListRequestDTO(postId));
        Set<Integer> usersSet = new LinkedHashSet<>();
        List<UserProfileData> userList = new ArrayList<>();
        usersSet.add(forumPost.getUserId());
        for (int i=0; i<forumComments.toArray().length; i++) {
            usersSet.add(forumComments.get(i).getUserId());
        }
        for(int id : usersSet){
            UserProfile profile = userService.getUserProfile(
                new UserProfileRequestDTO(id)
            );
            System.out.println(profile.getId() + " " + profile.getName());
            userList.add(new UserProfileData(profile.getId(), profile.getName()));
        }
        model.addAttribute("post", forumPost);
        model.addAttribute("comments", forumComments);
        model.addAttribute("users", userList);
        return "Post";

    }
}
