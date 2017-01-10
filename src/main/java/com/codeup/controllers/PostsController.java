package com.codeup.controllers;

import com.codeup.Dao.DaoFactory;
import com.codeup.Dao.Posts;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
    public String index(Model m) {
//        List posts = DaoFactory.getPostsDao().all();
        m.addAttribute("posts", DaoFactory.getPostsDao().all());
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreatePost(Model m) {
        m.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String createNewPost(@Valid Post postCreated, Errors validation, Model m){

        if(validation.hasErrors()){
            m.addAttribute("errors", validation);
            m.addAttribute("post", postCreated);
            return "posts/create";

        }
        DaoFactory.getPostsDao().savePost(postCreated);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable long id, Model m){
        m.addAttribute("post", DaoFactory.getPostsDao().findPostById(id));
        return "posts/show";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable long id, Model m){
        m.addAttribute("post", DaoFactory.getPostsDao().findPostById(id));
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid Post editedPost, Errors validation, Model m){

        if(validation.hasErrors()){
            m.addAttribute("errors", validation);
            m.addAttribute("post", editedPost);
            return "posts/edit";
        }

        Post existingPost = DaoFactory.getPostsDao().findPostById(editedPost.getId());
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();

        existingPost.setTitle(newTitle);
        existingPost.setBody(newBody);

        DaoFactory.getPostsDao().updatePost(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }

    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable long id){
        DaoFactory.getPostsDao().deletePosts(id);
        return "redirect:/posts";
    }
}
