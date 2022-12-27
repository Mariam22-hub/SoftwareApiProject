package com.example.SoftwareApiProject.Models;

public abstract class IWallet {

    public abstract double getAmount();

    public abstract void setAmount(double am);

    public abstract void decriment(double am);

    public abstract void incriment(double am);
}