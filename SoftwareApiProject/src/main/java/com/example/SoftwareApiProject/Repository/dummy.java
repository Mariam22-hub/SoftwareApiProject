package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.SoftwareApiProject.Repository.servicesProvidersRepository.serviceProviders;


public class dummy {
    @Autowired
    servicesProvidersRepository repo;

    public dummy() {
        serviceProviders.add((Service) repo.internetEtisalat);
        serviceProviders.add((Service) repo.internetOrange);
        serviceProviders.add((Service) repo.internetVodafone);
        serviceProviders.add((Service) repo.internetWE);
    }

}
