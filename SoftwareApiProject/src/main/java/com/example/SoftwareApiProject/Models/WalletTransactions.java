package com.example.SoftwareApiProject.Models;

public class WalletTransactions {
    User user;
    double amount;
    public WalletTransactions(User user,double amount){
        this.user = user;
        this.amount = amount;
    }
}
