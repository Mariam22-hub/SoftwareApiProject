package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.Transactions;

import java.util.ArrayList;

public interface adminServices {
    public String addProvider();

    String addOverallDiscount(double percentage);

    //Transactions getRefundReq();

    ArrayList<Transactions> listAllRefundReq();

    String updateRefund(int transId, int refundState);

    String addSpecificDiscount(double percentage, String serviceName);
}
