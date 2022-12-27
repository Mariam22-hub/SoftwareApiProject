//package com.example.SoftwareApiProject.entity;
//
//
//import static com.example.SoftwareApiProject.entity.User.transactions;
//
//public class CreditCard extends IcreditCard{
//    private String ID;
//    private String password;
//    private double amount;
//    IUser user;
//
//    public CreditCard(IUser user, String password, double amount){
//        this.user = user;
//        this.ID = ID;
//        this.password=password;
//        this.amount=amount;
//    }
//
//    public double getAmount(){
//        return amount;
//    }
//
//    public void setAmount(double Amount){
//        this.amount = Amount;
//    }
//
//
//
//    public void decrement(double am) {
//        amount -= am;
//        transactions.add(am);
//    }
//    public void increment(double amount){
//        double newAmount = getAmount()+amount;
//        setAmount(newAmount);
//    }
//
//}
