package com.example.SoftwareApiProject.controller;

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

    @PostMapping("/users/register")
    public String addUser(@Valid @RequestBody User user){
        return service.addUser(user);
    }

    @PostMapping("/users/login/{username}/{password}/{email}")
    public String signIn(@PathVariable("username") String username,@PathVariable("password") String password, @PathVariable ("email") String email){
        return service.signIn(username, password, email);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable ("username") String name){
        System.out.println("-- Your account information --");
        return service.getUser(name);
    }

    @GetMapping("/users/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName){
        return ResponseEntity.ok(service.subscribe(username, serviceName));
    }
    @GetMapping("/users/pay")
    public ResponseEntity<String> pay(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName, @RequestParam(value ="PaymentMethod") String PaymentMethod)
    {
        return ResponseEntity.ok(service.pay(username,serviceName,PaymentMethod));
    }
    @GetMapping ("/users/search")
    public ResponseEntity<ArrayList<Services>> search (@RequestParam(value = "serviceName") String serviceName){
        return ResponseEntity.ok(service.search(serviceName));
    }
    @GetMapping("/users/refund")
    public ResponseEntity<String> refund(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName)
    {
        return ResponseEntity.ok(service.doRefund(username,serviceName));
    }
    @GetMapping("/users/checkRefund")
    public ResponseEntity<String> checkRefund(@RequestParam(value = "username") String username, @RequestParam(value = "serviceName") String serviceName)
    {
        return ResponseEntity.ok(service.checkRefund(username,serviceName));
    }
    @GetMapping("/users/addFunds")
    public ResponseEntity<String> addFunds(@RequestParam(value = "amount") double amount, @RequestParam(value = "username") String username)
    {
        return ResponseEntity.ok(service.addFunds(amount, username));
    }

    @PostMapping("/users/logOut/{username}")
    public String logOut(@Valid @PathVariable ("username") String name){
        return service.logOut(name);
    }

}
