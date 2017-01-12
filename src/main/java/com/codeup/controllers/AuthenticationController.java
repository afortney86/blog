package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by anthonyfortney on 1/10/17.
 */

@Controller
@RequestMapping("/user")
public class AuthenticationController extends BaseController{

    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login";
    }


}