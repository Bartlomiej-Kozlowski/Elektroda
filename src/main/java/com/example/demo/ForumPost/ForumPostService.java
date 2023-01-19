package com.example.demo.ForumPost;

import com.example.demo.AuthToken.JwtTokenUtil;
import com.example.demo.ForumComment.ForumComment;
import com.example.demo.ForumComment.ForumCommentWithUser;
import com.example.demo.ForumComment.ForumCommentWithUserData;
import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserId;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForumPostService {
    private ForumPostRepository forumPostRepository;
    private UserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public ForumPostService(ForumPostRepository forumPostRepository, UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.forumPostRepository = forumPostRepository;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ForumPostWithUserData getForumPost(String token, Integer postId){
        ForumPostWithUserData postWithUserData;
        String email = jwtTokenUtil.getEmailFromToken(token);
        if (email != null){
            ForumPostWithUser post = userRepository.findUserIdByEmail(email)
                    .map((UserId userid) ->
                            forumPostRepository.findForumPostWithUserByPostId(
                                    postId, userid.getId()
                            )
                            .orElseThrow(() -> new NullPointerException("No post was found"))
                    )
                    .orElseThrow(() -> new NullPointerException("No access rights to edit this comment"));
            postWithUserData = new ForumPostWithUserData(
                    post.getId(),
                    post.getTopicName(),
                    post.getContent(),
                    post.getUserId(),
                    post.getThreadId(),
                    post.getDateOfCreation(),
                    post.getDateOfLastEdit(),
                    post.getItsMe(), 1,0
            );
        }else{
            ForumPost post = this.forumPostRepository.findForumPostByPostId(postId)
                    .orElseThrow(() -> new NullPointerException("Post not found"));

            postWithUserData = new ForumPostWithUserData(
                    post.getId(),
                    post.getTopicName(),
                    post.getContent(),
                    post.getUserId(),
                    post.getThreadId(),
                    post.getDateOfCreation(),
                    post.getDateOfLastEdit(),
                    0, 0,0
            );
        }
        return postWithUserData;
    }

    public List<ForumPostWithoutContent> getForumPosts(ForumPostListRequestDTO forumPostListRequestDTO){
        return this.forumPostRepository.findForumPostsByThreadId(forumPostListRequestDTO.threadId());
    }

    public ForumPost addForumPost(ForumPost forumPost){
        this.forumPostRepository.save(forumPost);
        return forumPost;
    }
}