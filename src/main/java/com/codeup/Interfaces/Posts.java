package com.codeup.Interfaces;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by anthonyfortney on 1/5/17.
 */
public interface Posts extends CrudRepository<Post, Long> {



}
