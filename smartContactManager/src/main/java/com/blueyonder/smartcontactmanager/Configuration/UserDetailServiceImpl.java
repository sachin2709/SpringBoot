package com.blueyonder.smartcontactmanager.Configuration;

import com.blueyonder.smartcontactmanager.Models.User;
import com.blueyonder.smartcontactmanager.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    UserDetailServiceImpl(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //fetching user from database

       User user= userRepository.getUserByUserName(username);
       if(user==null)
       {
           throw new UsernameNotFoundException("Could not found User !!");

       }

//       CustomUserDetails customUserDetails=new CustomUserDetails(user);


        return new CustomUserDetails(user);
    }
}
