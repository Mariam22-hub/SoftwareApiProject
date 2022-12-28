package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Internet.InternetEtisalat;
import com.example.SoftwareApiProject.Models.Internet.InternetOrange;
import com.example.SoftwareApiProject.Models.Internet.InternetVodafone;
import com.example.SoftwareApiProject.Models.Internet.InternetWE;
import com.example.SoftwareApiProject.Models.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
