package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by anthonyfortney on 1/11/17.
 */

@Controller
public class UsersController {


        @GetMapping("/register")
        public String showRegisterForm() {
            return "register/register";
        }
    }
