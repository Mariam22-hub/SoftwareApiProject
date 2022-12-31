package com.example.SoftwareApiProject.Models;


import java.util.ArrayList;

public class User{

    //    public static ArrayList<Double> transactions = new ArrayList<Double>();
    String username;
    String password;
    String refundState;
    String email;
    public Wallet wallet;
    public ArrayList<Transactions> transactionPay = new ArrayList<>();
    public ArrayList<Transactions> refundTransactions = new ArrayList<>();

    public CreditCard creditCard;
    String serviceType = "";
    boolean signedIn = false;

    public boolean getisSignedIn() {
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public User() {
    }
    public User(String username, String password, String email, Wallet wallet, CreditCard creditCard) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.wallet = wallet;
        this.creditCard = creditCard;
    }
    public User (String username,String password){
        this.username= username;
        this.password = password;
        this.wallet = new Wallet(50);
    }



//    public double checkType(String payMethod, double pay){
//        if (payMethod.equals("CreditCard")){
//            return creditCard.amount;
//        }
//        else if (payMethod.equals("Wallet")){
//            return wallet.amount;
//        }
//        else {
//                return pay;
//        }
//    }




}

