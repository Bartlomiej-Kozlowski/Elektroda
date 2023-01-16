package com.example.demo.ForumComment;

import com.example.demo.ForumComment.ForumComment;
import com.example.demo.ForumComment.ForumCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ForumCommentService {
    private ForumCommentRepository forumCommentRepository;

    @Autowired
    public ForumCommentService(ForumCommentRepository forumCommentRepository){
        this.forumCommentRepository = forumCommentRepository;
    }

    public List<ForumComment> getForumComments(@RequestBody ForumCommentListRequestDTO forumComment){
        return this.forumCommentRepository.findForumCommentsByPostId(forumComment.postId());
    }

    public boolean addForumComment(ForumCommentAddRequestDTO forumComment){
//        this.forumCommentRepository.save(forumComment);
        return true;
    }
}
