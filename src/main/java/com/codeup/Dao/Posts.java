package com.codeup.Dao;

import com.codeup.models.Post;

import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
public interface Posts {

    List<Post> all();

    void savePost(Post post);

    Post findPostById(long id);

    void updatePost(Post existingPost);

    void deletePosts(long id);

}
