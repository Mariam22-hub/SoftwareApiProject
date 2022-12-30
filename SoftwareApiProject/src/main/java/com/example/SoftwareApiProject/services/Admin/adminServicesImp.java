package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Repository.adminRepository;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import com.example.SoftwareApiProject.services.serviceProviders.servicesProvidersImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.SoftwareApiProject.Repository.adminRepository.overallDiscount;
import static com.example.SoftwareApiProject.Repository.adminRepository.specific;

@Service
public class adminServicesImp implements adminServices{

    @Autowired
    servicesProvidersRepository servicesRepo;
    @Autowired
    adminRepository adminRepo;
    @Override
    public String addProvider(){
        return null;
    }

    @Override
    public String addOverallDiscount(double percentage) {
        overallDiscount = new overall(percentage);
        overallDiscount.setFlag(true);
        return "Overall discount is added with " + percentage + "%";
    }

    @Override
    public String addSpecificDiscount(double percentage, String serviceName) {
    specific = new specific(percentage);
    Services s= servicesRepo.findSer(serviceName);
    s.setDiscountPercentage(percentage);
        return "Specific discount for "+ serviceName+" is added with " + percentage + "%";
    }


}
