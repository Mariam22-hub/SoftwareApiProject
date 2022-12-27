package com.example.SoftwareApiProject.Models;

public abstract class IcreditCard {
    public abstract double getAmount();
    public abstract void setAmount(double Amount);
    public abstract void decrement(double amount);
    public abstract void increment(double amount);
}
