package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import jakarta.validation.Valid;

public interface userService {
    public String addUser(@Valid User user);

    User getUser(String name);

    String subscribe(String username, String serviceName, String serviceType);

    String PayByWallet(String username, String serviceName);
}

