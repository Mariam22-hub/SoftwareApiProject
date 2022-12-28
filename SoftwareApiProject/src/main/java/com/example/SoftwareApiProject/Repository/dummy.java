package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Services;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.SoftwareApiProject.Repository.servicesProvidersRepository.serviceProviders;


public class dummy {
    @Autowired
    servicesProvidersRepository repo;

    public dummy() {
        serviceProviders.add((Services) repo.internetEtisalat);
        serviceProviders.add((Services) repo.internetOrange);
        serviceProviders.add((Services) repo.internetVodafone);
        serviceProviders.add((Services) repo.internetWE);
    }

}
