package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "users")

public class User {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    private List<Post> posts;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String password;

    public User() { }

    public User(User copy) {
        id = copy.id;
        posts = copy.posts;
        username = copy.username;
        email = copy.email;
        password = copy.password;
    }

    public User(String email, String username, List<Post> posts, String password) {
        this.username = username;
        this.posts = posts;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, List<Post> posts, String email, String password) {
        this.id = id;
        this.username = username;
        this.posts = posts;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() { return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
