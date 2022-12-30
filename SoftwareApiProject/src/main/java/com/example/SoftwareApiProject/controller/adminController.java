package com.example.SoftwareApiProject.controller;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.services.Admin.adminServicesImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Repository.adminRepository.overallDiscount;

@RestController
public class adminController {

    @Autowired
    adminServicesImp adminServices;

    @PostMapping("/admin/addService")
    public ResponseEntity<String> addProviders(Services service){
        return ResponseEntity.ok(adminServices.addProvider());
    }

    @PostMapping("/admin/addOverall")
    public String addOverallDiscount(@RequestParam (value = "percentage") double percentage){
        return adminServices.addOverallDiscount(percentage);
    }
    @PostMapping("/admin/specific")
    public String addSpecificDiscount(@RequestParam(value = "percentage") double percentage, @RequestParam(value = "serviceName") String serviceName){
        return adminServices.addSpecificDiscount(percentage,serviceName);
    }

    @GetMapping("/admin/listRefund")
    public ArrayList<Transactions> listAllRefundReq(){
        return adminServices.listAllRefundReq();

    }

    @GetMapping("/admin/setRefund")
    public ResponseEntity<String> handelRefunds(@RequestParam ("transId") int transId,@RequestParam ("refundState") int refundState){
        return ResponseEntity.ok(adminServices.updateRefund( transId,  refundState));
    }

}
