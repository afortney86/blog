package com.codeup.controllers;

import com.codeup.Interfaces.Users;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.fasterxml.jackson.databind.deser.Deserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UsersController extends BaseController {

    @Autowired
    private Users userDao;
    private Post posts;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public String showProfile(@PathVariable long id, Model m){
        User user = userDao.findOne(id);
        m.addAttribute("user", user);
        return "me";
    }

        @GetMapping("/me")
        public String me(){
            return "redirect:posts/userprofile/" + loggedInUser().getId();
        }

        @GetMapping("/register")
        public String showRegisterForm(Model model) {
            model.addAttribute("user", new User());
            return "register/register";
        }

        @PostMapping("/register")
        public String createNewUser(@ModelAttribute User userCreated){

            userDao.save(userCreated);
            return "redirect:/user/login";
        }

    }
