package com.blueyonder.includingcssandjsdemo.Controller;

import com.blueyonder.includingcssandjsdemo.Dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class testController {


    /***
     *
     *
     * as we are serving thymleaf pages from backend or server side ...so we add an empty object of logindto in that form and then send that form
     * so that whatever data the user enter that we can store that in object and can see that again at server side
     *
     *
     */


    @GetMapping("/form")
    public String openForm(Model model)
    {
        model.addAttribute("loginDto",new LoginDto());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("loginDto") LoginDto loginDto,BindingResult bindingResult)   //@ModelAttribute takes the name of object that comes from frontend and then Datatype in which we need to store that object and name of object
    {

        if(bindingResult.hasErrors()) {


            return "form";
        }





//        if (bindingResult.hasErrors()){
//            System.out.println("errors");
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError o : allErrors){
//                System.out.println("error -->  " + o.getDefaultMessage());
//            }
//
//        }
//
        System.out.println(loginDto);
        return "sucess";
    }

}
