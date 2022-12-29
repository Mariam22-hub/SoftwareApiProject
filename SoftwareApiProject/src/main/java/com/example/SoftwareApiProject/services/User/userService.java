package com.example.SoftwareApiProject.services.User;

import com.example.SoftwareApiProject.Models.User;
import jakarta.validation.Valid;

public interface userService {
    public String addUser(@Valid User user);

    User getUser(String name);

    String subscribe(String username, String serviceName);
}

