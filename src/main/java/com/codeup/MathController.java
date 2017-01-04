package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anthonyfortney on 1/4/17.
 */
@Controller
public class MathController {
    @RequestMapping (path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " plus " + number2 + " equals " + (number1+number2);
    }
    @RequestMapping (path = "/subtract/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " minus " + number2 + " equals " + (number1 - number2);
    }
    @RequestMapping (path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " times " + number2 + " equals " + (number1 * number2);
    }
    @RequestMapping (path = "/divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " plus " + number2 + " equals " + (number1 / number2);
    }
}
