package com.blueyonder.jpaspringbootexample;

import com.blueyonder.jpaspringbootexample.Entities.User;
import com.blueyonder.jpaspringbootexample.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaSpringBootExampleApplication {

    public static void main(String[] args) {


       ApplicationContext context= SpringApplication.run(JpaSpringBootExampleApplication.class, args);

      UserRepository userRepository= context.getBean(UserRepository.class);

//
//// Create------------------------------------------------------------------------------------------
//
//
//
//     for(int i=1;i<10;i++)
//     {
//         User user = new User();
//         user.setName("user " +  i);
//         user.setTech("tech " + i);
//         user.setEmail("user"+i+"@gmail.com");
//        //saving object one by one
//         userRepository.save(user);
//
//
//     }
//
//
//     List<User> user_list= new ArrayList<>();
//
//        for(int i=10;i<21;i++)
//        {
//            User user = new User();
//            user.setName("user " +  i);
//            user.setTech("tech " + i);
//            user.setEmail("user"+i+"@gmail.com");
//
//            user_list.add(user);
//
//
//        }
//
//
//        //saving complete iterable at once
//
//        userRepository.saveAll(user_list);
//




            //Update----------------------------------------------------------------------------------------


//        Optional<User> optional  = userRepository.findById(1602);
//
//        User user2=optional.get();
//        user2.setName("Updated Name");
//        user2.setTech("Updated Tech Stack");
//        user2.setEmail("Updated Email");
//
//        userRepository.save(user2);



        // Read -----------------------------------------------------------------------------------------

//        for (User user : userRepository.findAll()) {
//
//            System.out.println(user);
//
//        }



        //Delete ------------------------------------------------------------------------------------------------

//        userRepository.deleteById(1652);

        // deleteAll(), deleteAllById(Iterable)




        // By Default methods provides Basically crud operation over the primary key


        /* But what if you want to perform any operation over other fields (custom Finder methods or derived query methods )

            ex:- find by name
             find by name and password\

             data with name starting with prefix   in such cases you only need to specify return type and kind of prototype nothing
             else and the spring boot gives you the answer... you just need to specify return type and name of function and aruguments
             you dont need to write the implementation of it and giving the name of function and return type is also are in some format

             you cant give any random name

         */



//        custom find------------------------------------------------------------------------------------------------------

//        https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference

//        List<User> userListByname=userRepository.findByName("Sachin Mishra");
//
//        for( User user: userListByname)
//        {
//            System.out.println(user);
//        }
//

                List<User> userListByname=userRepository.findByNameStartingWithAndEmailLike("Sachin","sachin@test.com");

        for( User user: userListByname)
        {
            System.out.println(user);
        }

        // how to write custom query in JPA  and query can be JPQL query and can be native query

        /*

                                            ERRORS
              Errors are very easy to recognize just you have to see that what is the reason of that error and that you can be find very easily
              by seeing the error .....actually the name of the file and the name of calling function is started with packagename.filename.function
              so thats why it looks very big so if you learn how to read that then it will be easy for you to solve error


        */


                for(int i=1;i<=20;i++)
        {
            User user =new User();


            user.setName("User "+ i);

            user.setEmail("user"+i+"@gmail.com");

            user.setTech("Tech"+i);

            userRepository.save(user);

//            System.out.println(user1);


        }







        List<User> allUser = userRepository.getAllUser();

        for(User u:allUser)
        {
            System.out.println(u);
        }


        System.out.println("------------------------------------------------------------------------------");

        // parameteried custom query

        for (User user : userRepository.getUserByName("User 1")) {
            System.out.println(user);
        }


        System.out.println("------------------------------------------------------------------------------");


        List<User> list1=userRepository.getUsers();



        for(User u:list1)
        {
            System.out.println(u);
        }





    }

}
