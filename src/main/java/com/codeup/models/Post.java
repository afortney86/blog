package com.codeup.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title cannot be empty.")
    @Size(min = 3, message = "Must have a minimum of three characters.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Body cannot be empty")
    @Column(nullable = false)
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(){

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
