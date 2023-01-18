package com.example.demo.ForumComment;

import java.time.LocalDateTime;

public interface ForumCommentWithUser {
    Integer getId();
    String getContent();
    Integer getUserId();
    Integer getPostId();
    LocalDateTime getDateOfCreation();
    LocalDateTime getDateOfLastEdit();
    Integer getItsMe();
}
