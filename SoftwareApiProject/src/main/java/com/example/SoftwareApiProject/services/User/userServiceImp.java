package com.example.SoftwareApiProject.services.User;


import com.example.SoftwareApiProject.Models.AddWalletTransactions;
import com.example.SoftwareApiProject.Models.Payment.PayByCard;
import com.example.SoftwareApiProject.Models.Payment.PayByCash;
import com.example.SoftwareApiProject.Models.Payment.PayByWallet;
import com.example.SoftwareApiProject.Models.Payment.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Repository.userRepository;
import com.example.SoftwareApiProject.services.serviceProviders.servicesProvidersImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Repository.adminRepository.*;

@Service
public class userServiceImp implements userService {
    @Autowired
    userRepository userRepo;
    @Autowired
    servicesProvidersImp servicesimp;

    @Override
    public String addUser(User incomingUser) {
        return userRepo.addUser(incomingUser);
    }

    @Override
    public User getUser(String name) {
        return userRepo.getUser(name);
    }

    @Override
    public String subscribe(String username, String serviceName) {
        User user = userRepo.subscribe(username);

        if (user != null) {
            boolean flag = servicesimp.subscribeUser(serviceName, user);
            if (flag) {
                return "user subscribed successfully to " + serviceName;
            }
            else
                return "subscription failed, please try again";
        }
        return "user not found";
    }

    @Override
    public String signIn(String username, String password, String email) {
        return userRepo.signIn(username, password, email);
    }

    @Override

    public String pay(String username, String serviceName, String PaymentMethod) {
        User user = userRepo.getUser(username);
        Services service = servicesimp.findSer(serviceName);
        double amount = 0;

        Payment payMethod = checkPaymentType(PaymentMethod, user);
        service.setPayment(payMethod);

        if (overallDiscount.isFlag()){
            amount = overallDiscount.pay(service);
            amount = specific.pay(service,amount);
            return userRepo.pay(service , user, PaymentMethod, amount);
        }
        amount = service.pay();
        amount = specific.pay(service,amount);
        return userRepo.pay(service , user, PaymentMethod, amount);
    }


    @Override
    public String logOut(String name) {
        return userRepo.logOut(name);
    }

    @Override
    public String addFunds(double amount, String username) {
        User user = userRepo.getUser(username);

        if(user != null){

            user.wallet.increment(amount);
            user.creditCard.decrement(amount);

            AddWalletTransactions t = new AddWalletTransactions(user.getUsername(),amount);
            walletTransactions.add(t);

            return "amount: " + amount +" has been added to your wallet\nYour wallet's new balance is "+ user.wallet.getAmount();
        }

        return "please sign in first";

    }

    public Payment checkPaymentType(String PaymentMethod, User user){
        Payment payMethod=null;

        if(PaymentMethod.equals("Wallet")){
            payMethod = new PayByWallet(user.getWallet());
        }
        if(PaymentMethod.equals("CreditCard"))
        {
            payMethod = new PayByCard(user.getCreditCard());
        }
        if(PaymentMethod.equals("Cash"))
        {
            payMethod = new PayByCash(user.getUsername());
        }

        return payMethod;
    }



    @Override
    public ArrayList<Services> search(String serviceName) {
        return servicesimp.searchProviders(serviceName);
    }

    public String doRefund(String userName, String serviceName){
        User user = userRepo.getUser(userName);

        if (!user.getisSignedIn()){
            return "please sign in first";
        }

        Services service = servicesimp.findSer(serviceName);
        return userRepo.doRefund(user, service);

    }
    //if user want to check if his refund request is accepted or not
    public String checkRefund(String userName, String serviceName){
        User user = userRepo.getUser(userName);
        Services service = servicesimp.findSer(serviceName);
        for(int i=0; i<user.transactionPay.size(); i++) {
            if (!(user.transactionPay.get(i).isRefund()) && user.transactionPay.get(i).isRefunded() && user.transactionPay.get(i).isChecked()
                    && service.getName().equals(user.transactionPay.get(i).getService())) {
                user.transactionPay.remove(user.transactionPay.get(i));
                return "your request to "+service.getName()+" refund accepted successfully";
            }

            else if(!(user.transactionPay.get(i).isRefund()) && !(user.transactionPay.get(i).isRefunded()) && user.transactionPay.get(i).isChecked()
                    && service.getName().equals(user.transactionPay.get(i).getService()))

                return "your refund request rejected";
        }
        return "you haven't got response yet";
    }
}
