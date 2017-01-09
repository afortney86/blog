package com.codeup.controllers;

import com.codeup.Dao.DaoFactory;
import com.codeup.Dao.Posts;
import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
    public String index(Model m) {
        List<Post> posts = DaoFactory.getHibernatePostsDao().all();
        m.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreatePost(Model m) {
        m.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String createNewPost(@ModelAttribute Post post){
        DaoFactory.getHibernatePostsDao().savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable long id, Model m){
        m.addAttribute("post", DaoFactory.getHibernatePostsDao().findPostById(id));
        return "posts/show";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable long id, Model m){
        m.addAttribute("post", DaoFactory.getHibernatePostsDao().findPostById(id));
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute Post editedPost, @PathVariable long id){
        Post existingPost = DaoFactory.getHibernatePostsDao().findPostById(id);
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();

        existingPost.setTitle(newTitle);
        existingPost.setBody(newBody);

        DaoFactory.getHibernatePostsDao().updatePost(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }

    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable long id){
        DaoFactory.getHibernatePostsDao().deletePosts(id);
        return "redirect:/posts";
    }
}
