package com.example.SoftwareApiProject.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
@NoArgsConstructor

public class NewService implements Services{
    public static ArrayList<User> usersSubscribed = new ArrayList<User>();
    String name;
    double price;
    Payment p;
    @Override
    public double pay() {
        return p.pay(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public double DiscountPercentage = 100;

    @Override
    public double getDiscountPercentage() {
        return DiscountPercentage;
    }

    @Override
    public void setDiscountPercentage(double discountPercentage) {
        DiscountPercentage = 100-discountPercentage;
    }

    @Override
    public ArrayList<User> getArray() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public void setPayment(Payment payMethod) {
        this.p = payMethod;
    }
    public void addToArray( User user)
    {
        usersSubscribed.add(user);
    }
}
