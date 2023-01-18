package com.example.demo.ForumPost;

import java.time.LocalDateTime;

public class ForumPostWithUserData {
    Integer id;
    String topicName;
    String content;
    Integer userId;
    Integer threadId;
    LocalDateTime dateOfCreation;
    LocalDateTime dateOfLastEdit;
    Integer itsMe;
    Integer imAuthorized;
    Integer isLiked;

    public ForumPostWithUserData(Integer id,
                                 String topicName,
                                 String content,
                                 Integer userId,
                                 Integer threadId,
                                 LocalDateTime dateOfCreation,
                                 LocalDateTime dateOfLastEdit,
                                 Integer itsMe,
                                 Integer imAuthorized,
                                 Integer isLiked) {
        this.id = id;
        this.topicName = topicName;
        this.content = content;
        this.userId = userId;
        this.threadId = threadId;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastEdit = dateOfLastEdit;
        this.itsMe = itsMe;
        this.imAuthorized = imAuthorized;
        this.isLiked = isLiked;
    }

    public Integer getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getContent() {
        return content;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    public Integer getItsMe() {
        return itsMe;
    }

    public Integer getImAuthorized() {
        return imAuthorized;
    }

    public Integer getLiked() {
        return isLiked;
    }
}