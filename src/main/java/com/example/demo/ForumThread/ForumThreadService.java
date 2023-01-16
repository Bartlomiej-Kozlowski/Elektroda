package com.example.demo.ForumThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumThreadService {
    private ForumThreadRepository forumThreadRepository;

    @Autowired
    public ForumThreadService(ForumThreadRepository forumThreadRepository){
        this.forumThreadRepository = forumThreadRepository;
    }

    public List<ForumThread> getForumThreads(){
        return this.forumThreadRepository.findAll();
    }

    public ForumThread addForumThread(ForumThread forumThread){
        this.forumThreadRepository.save(forumThread);
        return forumThread;
    }
}
