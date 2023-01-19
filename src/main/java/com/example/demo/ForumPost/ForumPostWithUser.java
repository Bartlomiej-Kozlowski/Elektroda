package com.example.demo.ForumPost;

import com.example.demo.User.User;

import java.time.LocalDateTime;

public interface ForumPostWithUser {
    Integer getId();
    String getTopicName();
    String getContent();
//    User getUser();
    Integer getUserId();
    String getUserEmail();
    String getUserName();
    Integer getThreadId();
    LocalDateTime getDateOfCreation();
    LocalDateTime getDateOfLastEdit();
    Integer getItsMe();
}
