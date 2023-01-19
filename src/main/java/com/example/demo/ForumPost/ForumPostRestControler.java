package com.example.demo.ForumPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forumPost")
public class ForumPostRestControler {
    private ForumPostService forumPostService;

    @Autowired
    public ForumPostRestControler(ForumPostService forumPostService){
        this.forumPostService = forumPostService;
    }

    @PostMapping("/get")
    public ForumPostWithUserData getForumPost(@CookieValue(name = "authenticationToken", required=false) String token,
                                  @RequestBody ForumPostContentRequestDTO forumPost) {
        return forumPostService.getForumPost(token, forumPost.postId());
    }
    @PostMapping("/list")
    public List<ForumPostWithoutContent> getForumPosts(@RequestBody ForumPostListRequestDTO forumPostList) {
        return forumPostService.getForumPosts(forumPostList);
    }

}