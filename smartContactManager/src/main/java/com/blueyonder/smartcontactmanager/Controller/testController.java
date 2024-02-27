package com.blueyonder.smartcontactmanager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @GetMapping("/home")

    public String Home(Model model)
    {
        model.addAttribute("title","Home-Smart Contact Manager");

        return "home";
    }

    @GetMapping("/login")

    public String Login(Model model)
    {
        model.addAttribute("title","Login-Smart Contact Manager");

        return "Login";
    }

    @GetMapping("/signup")

    public String Signup(Model model)
    {
        model.addAttribute("title","Signup-Smart Contact Manager");

        return "Signup";
    }


    @GetMapping("/about")

    public String About(Model model)
    {
        model.addAttribute("title","About-Smart Contact Manager");

        return "about";
    }


}
