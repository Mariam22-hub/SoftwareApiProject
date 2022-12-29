package com.example.SoftwareApiProject.Models.Internet;//package com.example.SoftwareAPIProject.entity.Internet;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InternetOrange extends Services {

    public static ArrayList<User> usersSubscribed = new ArrayList<User>();

    public String name;
    public double price;
    Payment p;
    public double pay() {
        return p.pay(price);
    }
    public InternetOrange() {
        name = "InternetOrange";
        price = 250;

    }

    public String description() {

        return "welcome to the services of " + this.name;
    }

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


}
