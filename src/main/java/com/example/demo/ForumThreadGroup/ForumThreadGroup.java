package com.example.demo.ForumThreadGroup;

import javax.persistence.*;

@Entity
@Table
// if has no childs, then child will be forum thread
public class ForumThreadGroup {
    @Id
    @SequenceGenerator(
            name = "forum_thread_group_sequence",
            sequenceName = "forum_thread_group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "forum_thread_group_sequence"
    )
    private int id;
    private String name;
    private String description;
    private int threadGroupId = 0;  //parent thread group id or null

    public ForumThreadGroup(int id, String name, String description, int threadGroupId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.threadGroupId = threadGroupId;
    }
    public ForumThreadGroup(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ForumThreadGroup(String name, String description, int threadGroupId){
        this.name = name;
        this.description = description;
        this.threadGroupId = threadGroupId;
    }
    public ForumThreadGroup(String name, String description){
        this.name = name;
        this.description = description;
    }

    public ForumThreadGroup() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getThreadGroupId() {
        return threadGroupId;
    }

}
