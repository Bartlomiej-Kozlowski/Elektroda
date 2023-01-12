package com.example.demo.ForumThreadGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForumThreadGroupRepository extends JpaRepository <ForumThreadGroup, Integer> {
//    Optional<ForumThreadGroup> findForumThreadGroupsById
}
