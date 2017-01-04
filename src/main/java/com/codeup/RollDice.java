package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class RollDice {

    @GetMapping ("/roll-dice")
    public String welcome(){
        return "roll-dice";
    }

    @GetMapping ("/roll-dice/{userGuess}")
    public String userGuess(@PathVariable int userGuess, Model model) {
        model.addAttribute("userGuess", userGuess);
        return "roll-dice";

    }



}
