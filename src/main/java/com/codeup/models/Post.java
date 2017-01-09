package com.codeup.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "error message")
    @Size(min = 3, message = "error message")
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank(message = "error message")
    @Column(nullable = false, unique = true)
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
