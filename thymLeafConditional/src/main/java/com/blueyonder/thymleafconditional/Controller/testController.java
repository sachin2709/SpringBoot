package com.blueyonder.thymleafconditional.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class testController {



    @GetMapping("/conditional")
    public String DemoThymLeafConditioning(Model model)
    {

        model.addAttribute("gender","M");
        model.addAttribute("age",60);

        List<String> myList=List.of("Ritik","Ravinshu","Sachin");

        model.addAttribute("list",myList);


        return "conditional";
    }
}
