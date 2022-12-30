package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Donations.CancerHospitals;
import com.example.SoftwareApiProject.Models.Donations.NGOs;
import com.example.SoftwareApiProject.Models.Donations.School;
import com.example.SoftwareApiProject.Models.Internet.InternetEtisalat;
import com.example.SoftwareApiProject.Models.Internet.InternetOrange;
import com.example.SoftwareApiProject.Models.Internet.InternetVodafone;
import com.example.SoftwareApiProject.Models.Internet.InternetWE;
import com.example.SoftwareApiProject.Models.Landline.Monthly;
import com.example.SoftwareApiProject.Models.Landline.Quarter;
import com.example.SoftwareApiProject.Models.Mobile.MobileEtisalat;
import com.example.SoftwareApiProject.Models.Mobile.MobileOrange;
import com.example.SoftwareApiProject.Models.Mobile.MobileVodafone;
import com.example.SoftwareApiProject.Models.Mobile.MobileWE;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class servicesProvidersRepository {
    public static ArrayList<Services> serviceProviders = new ArrayList<Services>();

    public servicesProvidersRepository() {
        serviceProviders.add(new InternetEtisalat());
        serviceProviders.add(new InternetWE());
        serviceProviders.add(new InternetVodafone());
        serviceProviders.add(new InternetOrange());

        serviceProviders.add(new MobileOrange());
        serviceProviders.add(new MobileEtisalat());
        serviceProviders.add(new MobileVodafone());
        serviceProviders.add(new MobileWE());

        serviceProviders.add(new School());
        serviceProviders.add(new NGOs());
        serviceProviders.add(new CancerHospitals());

        serviceProviders.add(new Monthly());
        serviceProviders.add(new Quarter());
    }

    public boolean subscribeUser(User user, String serviceName) {
        for (Services service : serviceProviders) {
            if (service.getName().toLowerCase().equals(serviceName.toLowerCase())) {
                service.getArray().add(user);
                return true;
            }
        }
        return false;
    }

    public Services findSer(String serviceName) {
        for (Services service : serviceProviders) {
            if (service.getName().toLowerCase().equals(serviceName.toLowerCase())) {
                return service;
            }
        }
        return null;
    }

    public ArrayList<Services> searchProviders(String serviceName) {
        ArrayList<Services> services = new ArrayList<>();
        for (Services s : serviceProviders){
            if (s.getName().toLowerCase().contains(serviceName.toLowerCase())){
                services.add(s);
            }
        }
        return services;
    }

    public void insert(Services service){
        serviceProviders.add(service);
    }

}
