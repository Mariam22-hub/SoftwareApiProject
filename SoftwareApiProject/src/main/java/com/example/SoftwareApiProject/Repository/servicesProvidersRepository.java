package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Services;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class servicesProvidersRepository {
    public static ArrayList<Services> serviceProviders = new ArrayList<Services>();


    public String addServicesProviders(Services s){
        serviceProviders.add(s);
        return "service " + s.getName() + " was added";
    }

}
