package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.services.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    userService service;
    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user){
        return service.addUser(user);
    }
}
