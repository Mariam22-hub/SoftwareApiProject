package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.User;

public interface serviceProviders {

    public boolean subscribeUser(String serviceName, User user, String serviceType);
}