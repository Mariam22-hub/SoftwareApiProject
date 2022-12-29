package com.example.SoftwareApiProject.Models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Wallet{

    public double amount;
    public Wallet(double amount) {
        this.amount = amount;
    }

    public void setAmount(double am){
        amount = am;
    }

	public double getAmount(){
		return amount;
	}

    public void decrement(double am){
        amount -= am;
    }

    public void increment(double am){
        amount += am;
        this.setAmount(amount);
    }



}
