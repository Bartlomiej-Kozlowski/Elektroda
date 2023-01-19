package com.example.demo.ForumPost;

import com.example.demo.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumPostRepository extends JpaRepository <ForumPost, Integer> {
    //get everything except content, to show on post list
//    @Query("select f.id, f.userId, f.threadId, f.topicName from ForumPost f where f.threadId = ?1")
    @Query(
            value = "select f.id, f.user, f.thread_id as threadId, f.topic_name as topicName," +
            "f.date_of_creation as dateOfCreation, f.date_of_last_edit as dateOfLastEdit" +
            " from forum_post f where f.thread_id = ?1",
            nativeQuery = true
    )
    List<ForumPostWithoutContent> findForumPostsByThreadId(int threadId);

    //get content of a single post to show the actual post content
    @Query("select f from ForumPost f where f.id = ?1")
    Optional<ForumPost> findForumPostByPostId(int id);

    @Query(
            nativeQuery = true,
            value = "select f.id, f.topic_name as topicName, f.content as content, f.user_id as userId, f.thread_id as threadId," +
            "f.date_of_creation as dateOfCreation, f.date_of_last_edit as dateOfLastEdit, (f.user_id = :userId) as itsMe" +
            " from forum_post f where f.id = :postId"
    )
    Optional<ForumPostWithUser> findForumPostWithUserByPostId(Integer postId, Integer userId);
    List<ForumPost> findByThreadId(int threadId);
}
