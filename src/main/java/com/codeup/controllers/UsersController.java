package com.codeup.controllers;

import com.codeup.Interfaces.Users;
import com.codeup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private Users userDao;


        @GetMapping("/register")
        public String showRegisterForm(Model model) {
            model.addAttribute("user", new User());
            return "register/register";
        }

        @PostMapping("/register")
        public String createNewUser(User userCreated, Model model){
            model.addAttribute("user", userCreated);
            userDao.save(userCreated);
            return "login/login";
        }

    }
