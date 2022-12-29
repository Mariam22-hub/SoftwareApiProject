package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicesProvidersImp implements serviceProviders{
    @Autowired
    servicesProvidersRepository servicesRepo;

    @Override
    public boolean subscribeUser(String serviceName, User user, String serviceType) {
        return servicesRepo.subscribeUser(user, serviceName, serviceType);
    }
    public Services findSer(String s)
    {
        return servicesRepo.findSer(s);
    }
}
