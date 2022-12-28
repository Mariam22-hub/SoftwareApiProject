package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicesProvidersImp implements serviceProviders{
    @Autowired
    servicesProvidersRepository servicesRepo;

//    @Override
//    public String subscribeUser(String serviceName, User user) {
//        for (Services services : servicesProvidersRepository.serviceProviders){
//            if (serviceName.equals(services.getName())){
//                services.getArray().add(user);
//                return services.getName();
//            }
//        }
//        return null;
//    }

    //subscribing to vodafone
    @Override
    public String subscribeUser(String serviceName, User user, String serviceType) {
        return servicesRepo.subscribeUser(user, serviceName, serviceType);
    }
}
