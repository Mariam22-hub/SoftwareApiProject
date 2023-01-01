package com.example.SoftwareApiProject.Models.Payment;

import com.example.SoftwareApiProject.Models.CreditCard;

public class PayByCard implements Payment{

    String cardNum;
    CreditCard credit;

    public PayByCard(CreditCard Card){
        this.credit=Card;
    }


    public double pay(double amount) {

        if(credit.getAmount() >= amount){
            //credit.decrement(amount);
            System.out.println("Paid amount before discount: " + amount);
            return amount;
        }
        else
            System.out.println("No enough money in your credit card.\n");

        return 0;

    }

    public void UpdateAmount(double amount) {
        credit.decrement(amount);
    }
}
