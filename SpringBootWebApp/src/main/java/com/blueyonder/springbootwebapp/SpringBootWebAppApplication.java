package com.blueyonder.springbootwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebAppApplication.class, args);



/*

if ypu want that your application will reload automatically whenever you made any changes in the code or in the classpath
then you  should use spring dev tools  ...it will also auto restart the server


Features of Spring Dev tool

1) Property DevTools :- whenever use templaates like thymleaf in such cases that templates
                        get stored in cache and you try to reload the browser but changes will not reflect
                         in such cases spring dev tools false all the properties of cache and  when
                         cache properrties set to false then the change in code will reflect o change in browser

 2)  Automatic Restart

 3) Live Reload

 4)  Remote APplications


*/





    }

}
