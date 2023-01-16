package com.example.demo.ForumComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumCommentRepository extends JpaRepository <ForumComment, Integer> {
    @Query("select f from ForumComment f where f.postId = ?1 order by f.dateOfCreation")
    List<ForumComment> findForumCommentsByPostId(int postId);
}
