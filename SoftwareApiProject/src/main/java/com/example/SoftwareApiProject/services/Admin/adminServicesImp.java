
package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.AddWalletTransactions;
import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.NewService;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Repository.adminRepository;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.SoftwareApiProject.Repository.adminRepository.specific;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Repository.adminRepository.overallDiscount;

@Service
public class adminServicesImp implements adminServices {

    @Autowired
    servicesProvidersRepository servicesRepo;
    @Autowired
    adminRepository adminRepo;

    public String addProvider(Services service) {
       return adminRepo.addProvider(service);
    }


    public String addOverallDiscount(double percentage) {
        overallDiscount = new overall(percentage);
        overallDiscount.setFlag(true);
        return "Overall discount is added with " + percentage + "%";
    }

    @Override
    public ArrayList<Transactions> listAllRefundReq() {
        return adminRepo.findAllRefund();
    }

    public ArrayList<Transactions> userPayTrans(String userName) {
        return adminRepo.userPayTrans(userName);
    }

    @Override
    public String updateRefund(int transId, int refundState) {
        return adminRepo.updateUserRefund(transId, refundState);
    }

    @Override
    public String addSpecificDiscount(double percentage, String serviceName) {
        specific = new specific(percentage);
        Services s = servicesRepo.findSer(serviceName);
        s.setDiscountPercentage(percentage);
        return "Specific discount for " + serviceName + " is added with " + percentage + "%";
    }


    public ArrayList<AddWalletTransactions> userWalletTrans(String userName) {
        return adminRepo.userWalletTrans(userName);
    }

    public ArrayList<Transactions> listUserRefundReq(String userName) {
        return adminRepo.listUserRefundReq(userName);
    }
}



