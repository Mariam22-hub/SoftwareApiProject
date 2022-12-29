package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Repository.servicesProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServicesImp implements adminServices{
    @Autowired
    servicesProvidersRepository servicesRepo;

}
