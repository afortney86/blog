package com.codeup.models;

import com.codeup.Dao.SecurityConfiguration;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
    }
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        SecurityConfiguration sc = new SecurityConfiguration();
        this.password = sc.passwordEncoder().encode(password);
    }

    public List<Post> getPosts() {
        Collections.reverse(posts);
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}


