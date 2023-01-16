package com.example.demo.ForumPost;

import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ForumPostService {
    private ForumPostRepository forumPostRepository;

    @Autowired
    public ForumPostService(ForumPostRepository forumPostRepository){
        this.forumPostRepository = forumPostRepository;
    }

    public ForumPost getForumPost(ForumPostContentRequestDTO forumPostContentRequestDTO){
        return this.forumPostRepository.findForumPostByIdEquals(forumPostContentRequestDTO.postId());
    }

    public List<ForumPostWithoutContent> getForumPosts(ForumPostListRequestDTO forumPostListRequestDTO){
        return this.forumPostRepository.findForumPostsByThreadId(forumPostListRequestDTO.threadId());
    }

    public ForumPost addForumPost(ForumPost forumPost){
        this.forumPostRepository.save(forumPost);
        return forumPost;
    }
}