package com.example.SoftwareApiProject.Models;

public class PayByCash implements Payment{

    private String address;

    public PayByCash(String address){
        this.address = address;
    }

    public double pay(double amount) {
        System.out.println("paid amount: " + amount);
        return amount;
    }

}
