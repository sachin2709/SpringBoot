package com.blueyonder.inheretingthymleaftemplate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/about")
    public String aboutController(Model model)
    {


        return "about";
    }


}
