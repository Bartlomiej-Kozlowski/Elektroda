package com.example.demo.ForumComment;

import java.time.LocalDateTime;

public class ForumCommentWithUserData{
    Integer id;
    String content;
    Integer userId;
    Integer postId;
    LocalDateTime dateOfCreation;
    LocalDateTime dateOfLastEdit;
    Integer itsMe;
    Integer imAuthorized;
    Integer isLiked;

    public ForumCommentWithUserData(Integer id,
                                    String content,
                                    Integer userId,
                                    Integer postId,
                                    LocalDateTime dateOfCreation,
                                    LocalDateTime dateOfLastEdit,
                                    Integer itsMe,
                                    Integer imAuthorized,
                                    Integer isLiked) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastEdit = dateOfLastEdit;
        this.itsMe = itsMe;
        this.imAuthorized = imAuthorized;
        this.isLiked = isLiked;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPostId() {
        return postId;
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
