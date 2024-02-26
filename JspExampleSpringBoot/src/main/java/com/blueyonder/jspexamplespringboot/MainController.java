package com.blueyonder.jspexamplespringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/")
    public String firstController()
    {

        return "home";

    }

    @RequestMapping("/contact")
    public String secondController()
    {
        return "contact";
    }


}
