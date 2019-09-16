package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "posts")
public class Post {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String description;

//    @OneToOne
//    private User owner;
    @ManyToOne
    @JsonManagedReference
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Image> images;

    public Post() { }

    public Post(String title, String description, User owner, List<Image> images) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.images = images;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}



