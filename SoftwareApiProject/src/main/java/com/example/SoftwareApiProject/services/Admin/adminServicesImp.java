package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServicesImp implements adminServices{
    @Override
    public String addProvider(){
        return null;
    }
    @Autowired
    servicesProvidersRepository servicesRepo;

}
