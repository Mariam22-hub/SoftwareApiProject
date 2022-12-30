package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.NewService;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;
import java.util.Objects;

public interface adminServices {
//    public String addProvider(NewService service);

    String addProvider();

    String addOverallDiscount(double percentage);


    ArrayList<Transactions> listAllRefundReq();

    String updateRefund(int transId, int refundState);

    String addSpecificDiscount(double percentage, String serviceName);

}
