package com.example.SoftwareApiProject.Models.Vodafone;

import com.example.SoftwareApiProject.Models.Provider;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public interface Vodafone extends Provider {

    String name = "vodafone";
    public static ArrayList<User> usersSubscribed = new ArrayList<User>();
    public String getName();

    public double getPrice();

    public ArrayList<User> getArray();

    public String description();
}
