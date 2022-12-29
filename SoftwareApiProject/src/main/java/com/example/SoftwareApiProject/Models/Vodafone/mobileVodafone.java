package com.example.SoftwareApiProject.Models.Vodafone;

import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class mobileVodafone implements Vodafone{
    public static String name = "MobileVodafone";
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
