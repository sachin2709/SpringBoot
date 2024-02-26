package com.blueyonder.fileuploaddemofirst.Controller;


import com.blueyonder.fileuploaddemofirst.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {


        /***

         Tips :- 1) For direct moving cursor to next line use shift+Enter
         2) For autoCompleting name of any function just use first letter of all words that the name contains,

         ex:- getOriginalFilename  ( after file. type gof and press enter it got completed)

         Some functions related to file are below :-

         System.out.println(file.getOriginalFilename());
         System.out.println(file.getContentType());

         System.out.println(file.getSize());

         System.out.println(file.getName());


         For sending files from postman use the body and select form data and while sending the request keep remember that the name of file should be fine otherwise
         dont know but there may be some prolem while sending file.


         ***/


        System.out.println(file.getContentType());

        try {
            System.out.println(file.getContentType());


            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please Upload a file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg file permitted");

            }

            boolean f = false;
            f = fileUploadHelper.uploadFile(file);

            if (!f) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is some issue with Your file");

            }

//            return ResponseEntity.status(HttpStatus.OK).body("File Uploaded Succesfully");

            //If You want to return your image in response then



            return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());


            /***
            ServletUriComponentsBuilder.fromCurrentContextPath will give you uri upto localhost:8080 after that you
            need to add remaining path so you just added /image and getOriginalFilename as string.

             usually the above path in response entity gives the path of static folder of target not of the normal folder of our package

             ....and basically target is the folder that is generated while building the project and that folder is only used
             while deploying to server




             **/



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

        }






}
