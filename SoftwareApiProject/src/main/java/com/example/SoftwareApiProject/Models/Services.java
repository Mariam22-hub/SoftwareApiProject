package com.example.SoftwareApiProject.Models;

import java.util.ArrayList;

public interface Services {

    public Payment payment = null;
    public abstract double pay();

    public String getName();

    public double getPrice();

    public ArrayList<User> getArray();

    public String description();

}
