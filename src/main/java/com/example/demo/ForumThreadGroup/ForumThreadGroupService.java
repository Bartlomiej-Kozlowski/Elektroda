package com.example.demo.ForumThreadGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumThreadGroupService {
    private ForumThreadGroupRepository forumThreadGroupRepository;

    @Autowired
    public ForumThreadGroupService(ForumThreadGroupRepository forumThreadGroupRepository){
        this.forumThreadGroupRepository = forumThreadGroupRepository;
    }

    public List<ForumThreadGroup> getForumThreadGroups(){
        return this.forumThreadGroupRepository.findAll();
    }

    public ForumThreadGroup addForumThreadGroup(ForumThreadGroup forumThreadGroup){
        this.forumThreadGroupRepository.save(forumThreadGroup);
        return forumThreadGroup;
    }
}
