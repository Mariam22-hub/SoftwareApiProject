package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.SoftwareApiProject.Repository.adminRepository.overallDiscount;

@Service
public class adminServicesImp implements adminServices{

    @Autowired
    servicesProvidersRepository servicesRepo;
    @Override
    public String addProvider(){
        return null;
    }

    @Override
    public String addOverallDiscount(double percentage) {
//        overallDiscount = new overall(percentage);
//        overallDiscount.setFlag(true);
        return "Overall discount is added with " + percentage + "%";
    }


}
