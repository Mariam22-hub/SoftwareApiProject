package com.example.SoftwareApiProject.services;

import com.example.SoftwareApiProject.Models.User;
import jakarta.validation.Valid;

public interface userService {
    public String addUser(@Valid User user);
}
