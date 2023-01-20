package com.example.demo.ForumThread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumThreadRepository extends JpaRepository <ForumThread, Integer> {
    public List<ForumThread> findByThreadGroupId(int threadGroupId);
    public ForumThread findById(int id);

    @Query("select f from ForumThread f where f.name = ?1 or f.description = ?2")
    public List<ForumThread> findByNameOrDescription(String name, String description);
}
