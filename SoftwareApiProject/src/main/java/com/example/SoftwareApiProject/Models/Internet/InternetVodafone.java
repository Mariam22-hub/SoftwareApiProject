package com.example.SoftwareApiProject.Models.Internet;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component

public class InternetVodafone extends Services {
    public static ArrayList<User> usersSubscribed = new ArrayList<User>();

    public String name;
    public double price;
    Payment p;
    public double pay() {
        return p.pay(price);
    }

    public Payment payment;

    public InternetVodafone() {
        price = 100;
        name = "InternetVodafone";
    }


    public String description() {

        return "welcome to the services of " + this.name;
    }

    @Override
    public void setPayment(Payment payMethod) {
        this.payment = payMethod;
    }

    @Override
    public double pay() {
        return 0;
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
