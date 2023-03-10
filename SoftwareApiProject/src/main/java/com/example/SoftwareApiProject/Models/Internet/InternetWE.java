package com.example.SoftwareApiProject.Models.Internet;

import com.example.SoftwareApiProject.Models.Payment.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class InternetWE implements Services {

    public static ArrayList<User> usersSubscribed = new ArrayList<User>();

    public String name;
    public double price;
    Payment p;
    public double pay() {
        return p.pay(price);
    }
    public InternetWE() {
        price = 190;
        name = "InternetWE";
    }
    public double DiscountPercentage =100;
    public double getDiscountPercentage() {
        return DiscountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        DiscountPercentage = 100-discountPercentage;
    }
    public String description() {

        return "welcome to the services of " + this.name;
    }

    @Override
    public void setPayment(Payment payMethod) {
        p = payMethod;
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
    public void addToArray( User user)
    {
        usersSubscribed.add(user);
    }

}
