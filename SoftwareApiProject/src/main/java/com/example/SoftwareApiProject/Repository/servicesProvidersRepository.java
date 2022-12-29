package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.*;
import com.example.SoftwareApiProject.Models.Vodafone.internetVodafone;
import com.example.SoftwareApiProject.Models.Vodafone.mobileVodafone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class servicesProvidersRepository {
    Services service;
    public static ArrayList<Provider> serviceProviders = new ArrayList<Provider>();
    @Autowired
    internetVodafone InternetVodafone;
    @Autowired
    mobileVodafone MobileVodafone;
    public servicesProvidersRepository() {
        serviceProviders.add(InternetVodafone);
        serviceProviders.add(MobileVodafone);
    }

    //for vodafone only
    public String subscribeUser(User user, String serviceName, String serviceType) {
        if (serviceName.equals("vodafone")){
            if (serviceType.equals("internet")){
                internetVodafone.usersSubscribed.add(user);
                return internetVodafone.name;
            }
            else if (serviceType.equals("mobile")){
                mobileVodafone.usersSubscribed.add(user);
                return mobileVodafone.name;
            }
        }
        return null;

    }



}
