
package com.example.SoftwareApiProject.Models;


public class CreditCard{

    public String ID;
    public String password;
    public double amount;

    public CreditCard(String ID, String password, double amount) {
        this.ID = ID;
        this.password = password;
        this.amount = amount;
    }
//    IUser user;

//    public CreditCard(IUser user, String password, double amount){
//        this.user = user;
//        this.ID = ID;
//        this.password=password;
//        this.amount=amount;
//    }

    public CreditCard(){

    }

//    public CreditCard(String ID, String password, double amount) {
//        super(ID, password, amount);
//    }

    public double getAmount(){
        return amount;
    }

    //    public void setAmount(double Amount){
//        this.amount = Amount;
//    }
//
//
//
    public void decrement(double am) {
        amount -= am;
        //transactions.add(am);
    }

    public void increment(double price) {
        amount+=price;
    }
//    public void increment(double amount){
//        double newAmount = getAmount()+amount;
//        setAmount(newAmount);
//    }

}
