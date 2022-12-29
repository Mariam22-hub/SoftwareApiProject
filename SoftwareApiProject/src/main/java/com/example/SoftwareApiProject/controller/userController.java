package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.services.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    @Autowired
    userService service;

    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable ("username") String name){
        return service.getUser(name);
    }

    //subscribe to vodafone
    @GetMapping("/users/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName, @RequestParam(value = "serviceType") String serviceType){
        return ResponseEntity.ok(service.subscribe(username, serviceName, serviceType));
    }

//    @PostMapping("/users/service")
//    public ResponseEntity<String> usersubscribe(@RequestParam(value = "username") String username, Provider provider){
//        return ResponseEntity.ok(service.subscribe(username, provider))
//    }
}
