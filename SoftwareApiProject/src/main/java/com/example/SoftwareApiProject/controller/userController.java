package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.services.User.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class userController {

    @Autowired
    userService service;

    @PostMapping("/user/registers")
    public String addUser(@Valid @RequestBody User user){
        return service.addUser(user);
    }

    @PostMapping("/user/login")
    public String signIn(@Valid @RequestBody User user){
        return service.signIn(user);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable ("username") String name){
        return service.getUser(name);
    }

    @GetMapping("/users/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName){
        return ResponseEntity.ok(service.subscribe(username, serviceName));
    }
    @GetMapping("/users/pay")
    public ResponseEntity<String> pay(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName, @RequestParam(value ="PaymentMethod") String PaymentMethod)
    {
        return ResponseEntity.ok(service.PayByWallet(username,serviceName,PaymentMethod));
    }
    @GetMapping ("/users/search")
    public ResponseEntity<ArrayList<Services>> search (@RequestParam(value = "serviceName") String serviceName){
        return ResponseEntity.ok(service.search(serviceName));
    }

}
