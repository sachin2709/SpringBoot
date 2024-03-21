package com.blueyonder.smartcontactmanager.Controller;

import com.blueyonder.smartcontactmanager.Helper.Messages;
import com.blueyonder.smartcontactmanager.Models.User;
import com.blueyonder.smartcontactmanager.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")

    public String Home(Model model)
    {
        model.addAttribute("title","Home-Smart Contact Manager");

        return "home";
    }

    @GetMapping("/sign_in")

    public String Login(Model model)
    {
        model.addAttribute("title","Login-Smart Contact Manager");

//        model.addAttribute("title","Signup-Smart Contact Manager");
        model.addAttribute("user",new User());

        return "signin";
    }

    @GetMapping("/signup")
    public String Signup(Model model)
    {
        model.addAttribute("title","Signup-Smart Contact Manager");
        model.addAttribute("user",new User());

        return "signup";
    }


    @PostMapping("/do_register")

    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult, @RequestParam(value = "agreement",required = false )boolean agreement, Model model, HttpSession session)
    {

//        System.out.println("Agreement"+ agreement);
//        System.out.println("User"+user);

        try {

            if (!agreement) {
                System.out.println("You have not agreed the terms and conditions");

                throw new Exception("You have not agreed the terms and conditions");


            }

            if(bindingResult.hasErrors())
            {
                System.out.println("Error "+bindingResult.toString());
                model.addAttribute("user",user);
                return "signup";
            }

            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("image.jpg");
            System.out.println("USER" + user);

            userRepository.save(user);

            model.addAttribute("user",new User());

        session.setAttribute("message",new Messages("Succesfully Registered !!", "alert-success"));





            return "signup";

        }
        catch(Exception e){

            model.addAttribute("user",user);
            session.setAttribute("message",new Messages("Something went wrong"+e.getMessage(),"alert-danger"));

            return "signup";

    }

    }


    @GetMapping("/about")

    public String About(Model model)
    {
        model.addAttribute("title","About-Smart Contact Manager");

        return "about";
    }


}
