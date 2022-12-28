package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.services.adminServicesImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class adminController {

    @Autowired
    adminServicesImp adminServices;

    @PostMapping("/providers")
    public String addUser(@Valid @RequestBody Services s){
        return adminServices.addServiceProviders(s);
    }
}
