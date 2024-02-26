package com.blueyonder.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String dummy()
    {
        return "heyyya Sachin this side";
    }
    
}
