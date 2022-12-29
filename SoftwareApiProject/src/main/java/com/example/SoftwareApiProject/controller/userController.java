package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.services.User.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class userController {

    @Autowired
    userService userservice;

    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user){
        return userservice.addUser(user);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable ("username") String name){
        return userservice.getUser(name);
    }

    @PostMapping("/users/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName){
        return ResponseEntity.ok(userservice.subscribe(username, serviceName));
    }

    @GetMapping("/users/pay")
    public ResponseEntity<Void> PayWallet(@Valid @RequestBody Services s, @PathVariable ("username") String name){
        User user = getUser(name);
        userservice.PayByWallet(s,user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("users/search")
    public ResponseEntity<ArrayList<Object>> search(){
        return null;
    }

}
