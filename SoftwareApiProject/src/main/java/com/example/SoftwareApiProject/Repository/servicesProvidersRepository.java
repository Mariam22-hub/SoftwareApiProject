package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Models.internetVodafone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class servicesProvidersRepository {
    public static ArrayList<Services> serviceProviders = new ArrayList<Services>();


//    public String addServicesProviders(Services s){
//        serviceProviders.add(s);
//        return "service " + s.getName() + " was added";
//    }

    //for vodafone only
    public String subscribeUser(User user) {
        internetVodafone.usersSubscribed.add(user);
        return internetVodafone.name;

    }

}
