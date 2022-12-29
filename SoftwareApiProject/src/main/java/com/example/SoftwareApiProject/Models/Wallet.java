package com.example.SoftwareApiProject.Models;

public class Wallet{

//    IUser user;

    public double amount;
    public Wallet(double amount) {
        this.amount = amount;
    }
    public Wallet(){
        amount =10000;
    }
    public void setAmount(double am){
        amount = am;
    }

	public double getAmount(){
		return amount;
	}

    public void decriment(double am){
        amount -= am;
        //transactions.add(am);
    }

    public void incriment(double am){
        amount += am;
        this.setAmount(amount);
    }



}
