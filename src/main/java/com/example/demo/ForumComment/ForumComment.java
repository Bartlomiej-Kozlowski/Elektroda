package com.example.demo.ForumComment;

import com.example.demo.ForumPost.ForumPost;
import com.example.demo.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ForumComment {
    @Id
    @SequenceGenerator(
            name = "forum_comment_sequence",
            sequenceName = "forum_comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "forum_comment_sequence"
    )
    private int id;
    private String content;
    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private User user; //user that made the comment;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastEdit;
    @ManyToOne
    @JoinColumn(name="postId", nullable = false)
    private ForumPost post;

    public ForumComment(int id, User user, String content, ForumPost post){
        this.id = id;
        this.user = user;
        this.content = content;
        this.dateOfCreation = LocalDateTime.now();
        this.post = post;
    }

    public ForumComment(User user, String content, ForumPost post){
        this.user = user;
        this.content = content;
        this.dateOfCreation = LocalDateTime.now();
        this.post = post;
    }

    public ForumComment() {

    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.dateOfLastEdit = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }
    public Integer getUserId() {
        return user.getId();
    }

    public ForumPost getPost() {
        return post;
    }

    public void setPost(ForumPost post) {
        this.post = post;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getDateOfLastEdit() {
        return dateOfLastEdit;
    }
}
