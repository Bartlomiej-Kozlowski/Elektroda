package com.example.demo.ForumComment;

import com.example.demo.ForumPost.ForumPost;

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
    private int userId; //user that made the comment;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastEdit;
    @ManyToOne
    @JoinColumn(name="postId", nullable = false)
    private ForumPost post;

    public ForumComment(int id, int userId, String content, ForumPost post){
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.dateOfCreation = LocalDateTime.now();
        this.post = post;
    }

    public ForumComment(int userId, String content){
        this.userId = userId;
        this.content = content;
        this.dateOfCreation = LocalDateTime.now();
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

    public int getUserId() {
        return userId;
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
