package com.example.demo.ForumThread;

import javax.persistence.*;

@Entity
@Table
//same as ForumThreadGroup, but can be a parent for ForumPost
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

    public ForumThread(int id, int threadGroupId, String name, String description){
        this.id = id;
        this.threadGroupId = threadGroupId;
        this.name = name;
        this.description = description;
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

    public ForumThread(int threadGroupId, String name, String description){
        this.name = name;
        this.threadGroupId = threadGroupId;
        this.description = description;
    }

    public ForumThread() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
