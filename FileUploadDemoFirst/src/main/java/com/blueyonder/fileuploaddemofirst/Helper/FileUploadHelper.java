package com.blueyonder.fileuploaddemofirst.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {


    /***
     * location of directory where you want to upload the file ...
     *
     * usually the template folder of our project directory is used to store html files ,... and static folder is used to store css, js, and static files like images
     *
     * so thats why as of now we are uploading images there
     */

    //    public final String UPLOAD_DIR="F:\\Spring Boot\\FileUploadDemoFirst\\src\\main\\resources\\static\\images";



    /***
     *
     * above is the way of how you are defining path by yourself .. but it may cause problem when you are transferring your project
     * from one device to another ...so for solving this issue below is the way how we use this path dynamically
     *
     *
     */


    public final String UPLOAD_DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath();

    //CLassPathResource gives you path upto your classpath after that you only need to add static/images and then
    //for converting it into path just use getFile().getAbsolutePath();

    public  FileUploadHelper() throws IOException {

    }






    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean f=false;
        try{



//            InputStream is=multipartFile.getInputStream();
//            byte data[]=new byte[is.available()];
//
//            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//
//            fos.write(data);
//            fos.flush();
//            fos.close();
//
//            f=true;
//
//            return  f;

            /***
             *
             * above is the example of uploading files using large steps.....
             *
             * Below is example of uploading file using a single step
             *
             */

            Files.copy(multipartFile.getInputStream(),  Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            f=true;

            return f;


        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


}
