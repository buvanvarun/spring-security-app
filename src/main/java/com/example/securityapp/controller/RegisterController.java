package com.example.securityapp.controller;

import com.example.securityapp.model.Users;
import com.example.securityapp.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<Users> registerNewUser(@RequestBody Users user){
        return new ResponseEntity<>(service.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user){
        return new ResponseEntity<>(service.verifyUser(user),HttpStatus.OK);
    }
}
