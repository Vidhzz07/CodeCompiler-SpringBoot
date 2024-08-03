package com.example.ComplierModule.services;


import com.example.ComplierModule.entities.User;
import com.example.ComplierModule.entities.UserCode;
import com.example.ComplierModule.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;


    public User addUser(User user)
    {
        User localUser = new User();
        localUser.setUserName(user.getUserName());
        localUser.setPassword(passwordEncoder.encode(user.getPassword()));
        localUser.setRoles(List.of("USER"));
        return userRepo.save(localUser);
    }


    public User getUser(String userName)
    {
        return userRepo.findByUserName(userName);
    }


    public void deleteUser(String id)
    {
        userRepo.deleteById(id);
    }


    public List<UserCode> getUserSavedCodes(String userName)
    {
        return getUser(userName).getSavedCodes();
    }



}
