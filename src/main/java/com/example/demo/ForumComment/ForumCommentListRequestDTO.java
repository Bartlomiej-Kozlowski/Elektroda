package com.example.demo.ForumComment;

public record ForumCommentListRequestDTO(Integer postId) {
    public ForumCommentListRequestDTO(Integer postId) {
        this.postId = postId;
    }
}
