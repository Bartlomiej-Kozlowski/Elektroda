package com.example.demo.ForumComment;

import com.example.demo.ForumPost.ForumPost;
import com.example.demo.User.User;

import java.time.LocalDateTime;

public class ForumCommentWithUserData{
    Integer id;
    String content;
    User user;
    ForumPost post;
    LocalDateTime dateOfCreation;
    LocalDateTime dateOfLastEdit;
    Integer itsMe;
    Integer imAuthorized;
    Integer isLiked;

    public ForumCommentWithUserData(Integer id,
                                    String content,
                                    User user,
                                    ForumPost post,
                                    LocalDateTime dateOfCreation,
                                    LocalDateTime dateOfLastEdit,
                                    Integer itsMe,
                                    Integer imAuthorized,
                                    Integer isLiked) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
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

    public User getUserId() {
        return user;
    }

    public ForumPost getPost() {
        return post;
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
