package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table (name = "posts")
public class Post {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String description;
    @OneToOne
    private User owner;

    public Post() {

    }

    public Post(String title, String description, User owner) {
        this.title = title;
        this.description = description;
        this.owner=owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}



