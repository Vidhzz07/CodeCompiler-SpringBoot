package com.example.ComplierModule.services;

import com.example.ComplierModule.entities.User;
import com.example.ComplierModule.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userRepo.findByUserName(username);

        if(dbUser !=null)
        {
           return org.springframework.security.core.userdetails.User.builder()
                    .username(dbUser.getUserName())
                    .password(dbUser.getPassword())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .authorities(dbUser.getRoles().toArray(new String[0]))
                    .build();
        }

        else throw new  UsernameNotFoundException("Unknown user ,please check username");

    }
}
