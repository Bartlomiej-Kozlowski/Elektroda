package com.example.demo.ForumThread;

import javax.persistence.*;

@Entity
@Table
//same as ForumThreadGroup, but can be a parent for ForumPost
//will have a link redirecting to forum posts
public class ForumThread {
    @Id
    @SequenceGenerator(
            name = "forum_thread_sequence",
            sequenceName = "forum_thread_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "forum_thread_sequence"
    )
    private int id;
    private String name;
    private String description;
    private int threadGroupId;  //parent thread group id

    public ForumThread(int id, String name, String description, int threadGroupId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.threadGroupId = threadGroupId;
    }
    public ForumThread(String name, String description, int threadGroupId){
        this.name = name;
        this.description = description;
        this.threadGroupId = threadGroupId;
    }

    public ForumThread() {

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
