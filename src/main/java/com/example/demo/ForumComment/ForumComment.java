package com.example.demo.ForumComment;

import javax.persistence.*;

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
    private int postId; //replying to this post that made the comment;

    public ForumComment(int userId, int postId, String content){
        this.userId = userId;
        this.postId = postId;
        this.content = content;
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
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }
}
