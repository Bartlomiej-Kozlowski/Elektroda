package com.example.demo.ForumPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ForumPost getForumPost(@RequestBody ForumPostContentRequestDTO forumPost) {
//        return forumPostService.getForumPost(forumPost.postId);
        return forumPostService.getForumPost(forumPost);
    }
    @PostMapping("/list")
    public List<ForumPostWithoutContent> getForumPosts(@RequestBody ForumPostListRequestDTO forumPostList) {
//        return forumPostService.getForumPosts(forumPostList.threadId);
        return forumPostService.getForumPosts(forumPostList);
    }

}