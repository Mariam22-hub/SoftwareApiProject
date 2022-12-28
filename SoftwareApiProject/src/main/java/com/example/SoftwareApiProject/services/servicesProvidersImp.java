package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.Service;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class servicesProvidersImp implements serviceProviders{
    @Autowired
    servicesProvidersRepository servicesRepo;

    @Override
    public void subscribeUser(String serviceName, User user) {
        for (Service services : servicesRepo.serviceProviders){
            if (serviceName.equals(services.getName())){
                services.getArray().add(user);
            }
        }
    }
}
