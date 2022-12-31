package com.example.SoftwareApiProject.Models;

public class Transactions {
    private String serviceName;
    private String user;
    private double amount;
    private long id = 0;
    //if user want to refund a transaction -> refund = true
    //if admin accept refund -> refunded = true
    //if true true -> refund accepted
    //if true false -> refund rejected
    private boolean refund = false;
    private boolean refunded = false;
    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Transactions(String service) {
        this.serviceName = service;
    }

    public Transactions() {

    }

    public Transactions(String service, String user,double amount) {
        this.serviceName = service;
        this.user = user;
        this.amount = amount;
    }
    public void setId(long id) {
        this.id = id;
    }
    public  long getID(){
        return this.id;
    }

    public void incrementId(){
        this.id++;
    }


    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public String  getService() {
        return serviceName;
    }

    public void setService(String service) {
        this.serviceName = service;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
