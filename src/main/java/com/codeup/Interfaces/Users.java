package com.codeup.Interfaces;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anthonyfortney on 1/10/17.
 */
public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}