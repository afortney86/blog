package com.codeup;

import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
public interface Posts {

    List<Post> all();

    void savePost(Post post);

    void updatePost();

    void deletePosts();

}
