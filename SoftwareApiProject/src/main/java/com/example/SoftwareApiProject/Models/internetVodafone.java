package com.example.SoftwareApiProject.Models;

import java.util.ArrayList;

public class internetVodafone implements Vodafone{

    public static String name = "InternetVodafone";
    public double price = 150;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public ArrayList<User> getArray() {
        return usersSubscribed;
    }

    @Override
    public String description() {
        return "welcome to the services of Vodafone";
    }
}
