package com.blueyonder.thymleaftemplates.Controller;


//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {


    @GetMapping("/home")
    public String homeController(Model m)
    {


        m.addAttribute("title","Practicing");

        m.addAttribute("Subtitle","thymleaf");  //passing attributes to home

        return "Home";
    }


    @GetMapping("/about")
    public String aboutController()
    {


        return "about";
    }

    @GetMapping("/contact")
    public String contactController()
    {


        return "contact";
    }



}
