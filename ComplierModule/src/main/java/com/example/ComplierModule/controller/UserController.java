package com.example.ComplierModule.controller;


import com.example.ComplierModule.entities.User;
import com.example.ComplierModule.entities.UserCode;
import com.example.ComplierModule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user)
    {
        Authentication authentication  = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUserName(),
                user.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>("Sign in successfully",HttpStatus.OK);
    }




    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        try{
            User savedUser = userService.addUser(user);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/register/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) {
        try {
            User localUser = userService.getUser(userName);

            return new ResponseEntity<>(localUser, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }






}
