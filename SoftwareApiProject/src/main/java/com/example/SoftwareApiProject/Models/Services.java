package com.example.SoftwareApiProject.Models;

import java.util.ArrayList;

public abstract class Services {

    public static ArrayList<User> usersSubscribed = new ArrayList<User>();

    public String name;
    public double price;
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<User> getArray(){
        return usersSubscribed;
    }

    public String description() {
        return "welcome to the services of " + this.name;
    }
}
