package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Internet.InternetEtisalat;
import com.example.SoftwareApiProject.Models.Internet.InternetOrange;
import com.example.SoftwareApiProject.Models.Internet.InternetVodafone;
import com.example.SoftwareApiProject.Models.Internet.InternetWE;
import com.example.SoftwareApiProject.Models.Mobile.MobileEtisalat;
import com.example.SoftwareApiProject.Models.Mobile.MobileOrange;
import com.example.SoftwareApiProject.Models.Mobile.MobileVodafone;
import com.example.SoftwareApiProject.Models.Mobile.MobileWE;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class servicesProvidersRepository {
    @Autowired
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
    }

    public boolean subscribeUser(User user, String serviceName, String serviceType) {
        for (Services service : serviceProviders) {
            if (service.getName().equals(serviceName)) {
                service.getArray().add(user);
                return true;
            }
        }
        return false;
    }

    public Services findSer(String serviceName) {
        for (Services service : serviceProviders) {
            if (service.getName().equals(serviceName)) {
                return service;
            }
        }
        return null;
    }

}
