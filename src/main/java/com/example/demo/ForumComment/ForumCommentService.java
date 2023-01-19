package com.example.demo.ForumComment;

import com.example.demo.AuthToken.JwtTokenUtil;
import com.example.demo.ForumPost.ForumPost;
import com.example.demo.ForumPost.ForumPostRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserId;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForumCommentService {
    private ForumCommentRepository forumCommentRepository;
    private ForumPostRepository forumPostRepository;
    private UserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public ForumCommentService(ForumCommentRepository forumCommentRepository,
                               ForumPostRepository forumPostRepository,
                               UserRepository userRepository,
                               JwtTokenUtil jwtTokenUtil) {
        this.forumCommentRepository = forumCommentRepository;
        this.forumPostRepository = forumPostRepository;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public List<ForumCommentWithUserData> getForumComments(String token, ForumCommentListRequestDTO forumComment){
        List<ForumCommentWithUserData> commentList = new ArrayList<>();
        String email = jwtTokenUtil.getEmailFromToken(token);
        if (email != null){
            List<ForumCommentWithUser> commentTempList = userRepository.findUserByEmail(email)
                    .map((User user) ->
                            forumCommentRepository.findForumCommentsWithUserByPostId(
                                forumComment.postId(), user.getId()
                            )
                    )
                    .orElseThrow(() -> new NullPointerException("No access rights to edit this comment"));
            commentTempList.forEach((ForumCommentWithUser comment) ->
                    commentList.add(
                            new ForumCommentWithUserData(
                                    comment.getId(),
                                    comment.getContent(),
                                    comment.getUserId(),
                                    comment.getPost(),
                                    comment.getDateOfCreation(),
                                    comment.getDateOfLastEdit(),
                                    comment.getItsMe(), 1,0
                            )
                    )
            );
        }else{
            ForumPost post = this.forumPostRepository.findForumPostByPostId(forumComment.postId())
                .orElseThrow(() -> new NullPointerException("Post does not exist: " + forumComment.postId()));
//            this.forumCommentRepository.findForumCommentsByPostId(post)
            this.forumCommentRepository.findForumCommentsByPostId(forumComment.postId())
                .forEach((ForumComment comment) ->
                     commentList.add(
                         new ForumCommentWithUserData(
                             comment.getId(),
                             comment.getContent(),
                             comment.getUserId(),
                             comment.getPost(),
                             comment.getDateOfCreation(),
                             comment.getDateOfLastEdit(),
                             0, 0,0
                         )
                     )
                );
        }
        return commentList;
    }

    public void addForumComment(String token, ForumCommentAddRequestDTO forumComment){
        String email = jwtTokenUtil.getEmailFromToken(token); //check if the role has access to commenting this post;
        ForumPost post = forumPostRepository.findForumPostByPostId(forumComment.postId())
                .orElseThrow(() -> new NullPointerException("Forum post not found" + forumComment.postId()));
        userRepository.findUserByEmail(email)
                .map((User user) -> forumCommentRepository.save(new ForumComment(
                        user, forumComment.content(), post
                )))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + email));
    }

    @Transactional
    public void updateForumComment(String token, ForumCommentUpdateRequestDTO forumComment){
        String email = jwtTokenUtil.getEmailFromToken(token); //check if the role has access to commenting this post;
        ForumComment comment = userRepository.findUserIdByEmail(email)
                .map((UserId userId) ->
                        forumCommentRepository.findForumCommentByIdAndUserId(
                                forumComment.commentId(), userId.getId()
                                )
                                .orElseThrow(() -> new NullPointerException("No access rights to edit this comment"))
                )
                .orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));
        comment.setContent(forumComment.content());
    }

    public void deleteForumComment(String token, ForumCommentDeleteRequestDTO forumComment){
//        String username = jwtTokenUtil.getUsernameFromToken(token); //check if the role has access to commenting this post;
//        userRepository.findUserIdByName(username)
//                .map((UserId userId) -> forumCommentRepository.save(new ForumComment(
//                        userId.getId(), forumComment.postId(), forumComment.content()
//                )))
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
