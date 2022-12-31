package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.*;

import java.util.ArrayList;
import java.util.Objects;

public interface adminServices {
//    public String addProvider(NewService service);

    String addProvider(Services service);

    String addOverallDiscount(double percentage);

    public ArrayList<Transactions> listUserRefundReq(String userName);

    String updateRefund(int transId, int refundState);

    String addSpecificDiscount(double percentage, String serviceName);

    public ArrayList<AddWalletTransactions> userWalletTrans(String userName);
    public ArrayList<Transactions> userPayTrans(String userName);
    public ArrayList<Transactions> listAllRefundReq();

}
