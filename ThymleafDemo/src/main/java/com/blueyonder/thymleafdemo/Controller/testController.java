package com.blueyonder.thymleafdemo.Controller;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class testController {

    //thymleaf demo

//    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping("/home")
    public String test(Model model)
    {
        model.addAttribute("name","Sachin");
        model.addAttribute("education","MCA");


        List<String> names=List.of("Sachin","Vikas","Ritik","Ravinshu");
        model.addAttribute("names",names);


        System.out.println("Iam in Home controller");


        return "home";
    }


// Looping - Controller

    @GetMapping("/loop")
    public String Looping(Model model)
    {


        List<String> names=List.of("Sachin","Vikas","Ritik","Ravinshu");
        model.addAttribute("names",names);


        System.out.println("Iam in looping controller");


        return "loop";
    }

    @GetMapping("/conditional")
    public String conditional(Model model)
    {



        model.addAttribute("isActive",false);


        System.out.println("Iam in conditional controller");


        return "conditional";
    }



}
