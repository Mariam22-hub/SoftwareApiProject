package com.example.SoftwareApiProject.services.serviceProviders;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public interface serviceProviders {

    public boolean subscribeUser(String serviceName, User user);

    ArrayList<Services> searchProviders(String serviceName);
}
