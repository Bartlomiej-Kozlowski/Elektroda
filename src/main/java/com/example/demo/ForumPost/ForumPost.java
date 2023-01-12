package com.example.demo.ForumPost;

import javax.persistence.*;

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
    private int userId; //user that made the post;

    public ForumPost(int userId, String topicName, String content){
        this.userId = userId;
        this.topicName = topicName;
        this.content = content;
    }

    public ForumPost() {

    }

    public int getId() {
        return id;
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
}
