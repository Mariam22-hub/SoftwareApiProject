package com.example.SoftwareApiProject.services.User;

import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import jakarta.validation.Valid;

import java.util.ArrayList;

public interface userService {
    public String addUser(@Valid User user);

    User getUser(String name);

    String subscribe(String username, String serviceName);

    String PayByWallet(String username, String serviceName);

    public ArrayList<Services> search(String serviceName);
}

