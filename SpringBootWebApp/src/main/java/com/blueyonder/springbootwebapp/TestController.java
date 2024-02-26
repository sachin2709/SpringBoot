package com.blueyonder.springbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {


    @RequestMapping("/test")
    @ResponseBody  // this tells that we are returning objects or body not any view
    public String test()
    {
        int a=10;
        int b=20;
        int c=500;


        return "Sum of a , b and c  is "+(a+b+c);
    }


}
