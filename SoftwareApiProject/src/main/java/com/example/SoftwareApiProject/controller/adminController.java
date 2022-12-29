package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.services.Admin.adminServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class adminController {

    @Autowired
    adminServicesImp adminServices;

    @PostMapping("/admin/addService")
    public ResponseEntity<Void> addProviders(Services service){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
