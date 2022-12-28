package com.example.SoftwareApiProject.Models.Internet;

import com.example.SoftwareApiProject.Models.Service;
import com.example.SoftwareApiProject.Models.User;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class InternetVodafone implements Service {
    public static ArrayList<User> usersSubscribed = new ArrayList<User>();

    public String name;
    public double price;

    public InternetVodafone() {
        price = 100;
        name = "InternetVodafone";
    }


    public String description() {

        return "welcome to the services of " + this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<User> getArray() {
        return usersSubscribed;
    }


}
