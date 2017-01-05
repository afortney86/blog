package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by anthonyfortney on 1/4/17.
 */

@Controller
public class Resume {

        @GetMapping("/resume")
        public String seeResume() {
            return "resume";
        }


}
