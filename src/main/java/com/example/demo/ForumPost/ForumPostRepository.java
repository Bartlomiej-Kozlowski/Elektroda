package com.example.demo.ForumPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository <ForumPost, Integer> {
    //get everything except content, to show on post list
//    @Query("select f.id, f.userId, f.threadId, f.topicName from ForumPost f where f.threadId = ?1")
    @Query(value = "select f.id, f.user_id as userId, f.thread_id as threadId, f.topic_name as topicName from forum_post f where f.thread_id = ?1", nativeQuery = true)
    List<ForumPostWithoutContent> findForumPostsByThreadId(int threadId);

    //get content of a single post to show the actual post content
    @Query("select f from ForumPost f where f.id = ?1")
    ForumPost findForumPostByIdEquals(int id);
    List<ForumPost> findByThreadId(int threadId);
}
