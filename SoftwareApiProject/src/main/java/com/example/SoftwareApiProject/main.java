package com.example.SoftwareApiProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class main {
    @GetMapping("/")
    public String hello(){

        return "welcome to whatever";
    }
}

