package com.example.demo.ForumThread;

import com.example.demo.ForumComment.ForumComment;
import com.example.demo.ForumComment.ForumCommentRepository;
import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ForumThreadService {
    private ForumThreadRepository forumThreadRepository;
    private ForumPostRepository forumPostRepository;
    private ForumCommentRepository forumCommentRepository;

    @Autowired
    public ForumThreadService(ForumThreadRepository forumThreadRepository,
                              ForumPostRepository forumPostRepository,
                              ForumCommentRepository forumCommentRepository){
        this.forumThreadRepository = forumThreadRepository;
        this.forumPostRepository = forumPostRepository;
        this.forumCommentRepository = forumCommentRepository;
    }

    public List<ForumThread> getForumThreads(){
        return this.forumThreadRepository.findAll();
    }
    public List<ForumThread> getForumThreads(int id){
        return this.forumThreadRepository.findByThreadGroupId(id);
    }

    public ForumThread addForumThread(ForumThread forumThread){
        this.forumThreadRepository.save(forumThread);
        return forumThread;
    }
    public ForumThread getThread(int threadId){
        return this.forumThreadRepository.findById(threadId);
    }
    public List<ForumPost> getForumPost(int threadId){
        return this.forumPostRepository.findByThreadId(threadId);
    }
    public List<ForumThread> search(String search){
        return this.forumThreadRepository.findByNameOrDescription(search, search);
    }
}
