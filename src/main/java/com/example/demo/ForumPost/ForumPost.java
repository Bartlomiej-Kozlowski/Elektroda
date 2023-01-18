package com.example.demo.ForumPost;

import com.example.demo.ForumComment.ForumComment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class ForumPost {
    @Id
    @SequenceGenerator(
            name = "forum_post_sequence",
            sequenceName = "forum_post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "forum_post_sequence"
    )
    private int id;
    private String topicName;
    private String content;
    private int userId; //user that made the post;`
    private int threadId; //user that made the post;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastEdit;

    @OneToMany(mappedBy="post")
    private List<ForumComment> comments;

    public ForumPost(int id, int userId, int threadId, String topicName, String content){
        this.id = id;
        this.userId = userId;
        this.threadId = threadId;
        this.topicName = topicName;
        this.content = content;
        this.comments = new ArrayList<ForumComment>();
    }

    public ForumPost(int userId, int threadId, String topicName, String content){
        this.userId = userId;
        this.threadId = threadId;
        this.topicName = topicName;
        this.content = content;
    }

    public ForumPost() {

    }

    public int getId() {
        return id;
    }

    public int getThreadId() {
        return threadId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ForumComment> getComments() {
        return comments;
    }

    public void setComments(List<ForumComment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }
}
