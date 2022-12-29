package com.example.SoftwareApiProject.Models;

public class PayByWallet implements Payment {
    Wallet wallet;
    @Override
    public double pay(double amount) {

        if(wallet.getAmount() >= amount){
            System.out.println("paid amount: " + amount);
            return amount;
        }
        else {
            System.out.println("There is not enough money in your wallet.\n");
        }
        return 0;

    }

    public PayByWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void UpdateAmount(double amount) {
        wallet.decrement(amount);
    }
}
