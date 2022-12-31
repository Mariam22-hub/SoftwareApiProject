package com.example.SoftwareApiProject.services.User;


import com.example.SoftwareApiProject.Models.*;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import com.example.SoftwareApiProject.Repository.userRepository;
import com.example.SoftwareApiProject.services.serviceProviders.servicesProvidersImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Models.Admin.allTransactions;
import static com.example.SoftwareApiProject.Repository.adminRepository.*;
import static com.example.SoftwareApiProject.Repository.userRepository.loggedInUser;

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

            if (!user.getisSignedIn()){
                return "please sign in first";
            }
            boolean flag = servicesimp.subscribeUser(serviceName, user);
            if (flag) {
                return "user subscribed successfully to " + serviceName;
            }
            else
                return "subscription failed, please try again";
        }
        return "user not found";
    }


//    public String pay(String username, String serviceName, String PaymentMethod) {
//
//        User user = userRepo.getUser(username);
//
//        if (!user.getisSignedIn()){
//            return "please sign in first";
//        }
//
//        Services service = servicesimp.findSer(serviceName);
//
//        double amount = 0;
//        boolean flag = false;
//
//        for (User users : service.getArray()){
//            if (users == user){
//                flag = true;
//                break;
//            }
//        }
//
//        if (!flag){
//            return "user is not subscribed to this service";
//        }
//
//        Payment payMethod = checkPaymentType(PaymentMethod, user);
//        service.setPayment(payMethod);
//
//        if (overallDiscount.isFlag()){
//            amount = overallDiscount.pay(service);
//            amount = specific.pay(service,amount);
//            return userRepo.pay(service , user, PaymentMethod, amount);
//        }
//
//        amount = service.pay();
//        amount = specific.pay(service,amount);
//        return userRepo.pay(service , user, PaymentMethod, amount);
//    }

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
    public String addFunds(double amount, String username) {
        User user = userRepo.getUser(username);

//        if (user.getisSignedIn()){
//            loggedInUser = user;
//        }

        if(user != null){

            user.wallet.increment(amount);
            user.creditCard.decrement(amount);

            AddWalletTransactions t = new AddWalletTransactions(user.getUsername(),amount);
            walletTransactions.add(t);

            return "amount: " + amount +" has been added to your wallet\nYour wallet's new balance is "+ user.wallet.getAmount();
        }

        return "please sign in first";

    }

    @Override
    public String signIn(String username, String password, String email) {
        return userRepo.signIn(username, password, email);
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

//        for(int i=0; i<user.transactionPay.size(); i++){
//
//            if(user.transactionPay.get(i).getService().getName().toLowerCase().equals(service.getName().toLowerCase())  && !(user.transactionPay.get(i).isRefund())){
//                user.transactionPay.get(i).setRefund(true);
//                user.transactionPay.get(i).setUser(user.getUsername());
//
//                allTransactions.add(user.transactionPay.get(i));
//                return "refund request is completed";
//            }
//        }
        for(int i=0; i<user.transactionPay.size(); i++){
            if(user.transactionPay.get(i).getService().getName().equals(service.getName())  && !(user.transactionPay.get(i).isRefund())){
                user.transactionPay.get(i).setRefund(true);
                user.transactionPay.get(i).setUser(user.getUsername());
                Transactions tran = user.transactionPay.get(i);
                tran.setId(allTransactions.size());
                allTransactions.add(tran);
                user.refundTransactions.add(tran);
                return "refund process completed to "+user.transactionPay.get(i).getService().getName()+" service";
            }
        }
        return "you can not refund an uncompleted transaction";
    }
    //if user want to check if his refund request is accepted or not
    public String checkRefund(String userName, String serviceName){
        User user = userRepo.getUser(userName);
        Services service = servicesimp.findSer(serviceName);
        for(int i=0; i<user.transactionPay.size(); i++) {
            if (!(user.transactionPay.get(i).isRefund()) && user.transactionPay.get(i).isRefunded() && user.transactionPay.get(i).isChecked()
                    && service.getName().equals(user.transactionPay.get(i).getService().getName())) {
                user.transactionPay.remove(user.transactionPay.get(i));
                return "your request to "+service.getName()+" refund accepted successfully";
            }

            else if(!(user.transactionPay.get(i).isRefund()) && !(user.transactionPay.get(i).isRefunded()) && user.transactionPay.get(i).isChecked()
                    && service.getName().equals(user.transactionPay.get(i).getService().getName())) {
                user.transactionPay.remove(user.transactionPay.get(i));
                return "your refund request rejected";
            }
            else if((user.transactionPay.get(i).isRefund())&& !(user.transactionPay.get(i).isRefunded()) && !(user.transactionPay.get(i).isChecked())
                    && service.getName().equals(user.transactionPay.get(i).getService().getName()))

                return "you haven't got response yet";
        }

        return "you have no requests";
    }

    @Override
    public String logOut(String name) {
        return userRepo.logOut(name);
    }
}
