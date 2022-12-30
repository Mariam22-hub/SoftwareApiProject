package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.services.Admin.adminServicesImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.SoftwareApiProject.Repository.adminRepository.overallDiscount;

public class adminController {

    @Autowired
    adminServicesImp adminServices;

    @PostMapping("/admin/addService")
    public ResponseEntity<String> addProviders(Services service){
        return ResponseEntity.ok(adminServices.addProvider());
    }

    @PostMapping("/admin/addOverall")
    public String addOverallDiscount(@RequestParam (value = "percentage") double percentage, @Valid @RequestBody overall overalldiscount){
        overallDiscount = overalldiscount;
        return adminServices.addOverallDiscount(percentage);
    }

}
