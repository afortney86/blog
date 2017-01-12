package com.codeup.controllers;

import com.codeup.Interfaces.Users;
import com.codeup.models.User;
import com.fasterxml.jackson.databind.deser.Deserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController extends BaseController {

    @Autowired
    private Users userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

        @GetMapping("/me")
        public String showProfilePage(){

            return "posts/userprofile";
        }

        @GetMapping("/register")
        public String showRegisterForm(Model model) {
            model.addAttribute("user", new User());
            return "register/register";
        }

        @PostMapping("/register")
        public String createNewUser(@ModelAttribute User userCreated){

            userCreated.setPassword(passwordEncoder.encode(userCreated.getPassword()));

            userDao.save(userCreated);
            return "redirect:/user/login";
        }

    }
