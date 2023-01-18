package com.example.demo.ForumThread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumThreadRepository extends JpaRepository <ForumThread, Integer> {
    public List<ForumThread> findByThreadGroupId(int threadGroupId);
    public ForumThread findById(int id);
    public List<ForumThread> findByNameOrDescription(String name, String description);
}
