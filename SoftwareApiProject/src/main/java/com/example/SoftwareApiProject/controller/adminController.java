package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.services.Admin.adminServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class adminController {

    @Autowired
    adminServicesImp adminServices;

    @PostMapping("/admin/addService")
    public ResponseEntity<String> addProviders(Services service){
        return ResponseEntity.ok(adminServices.addProvider());
    }

}
