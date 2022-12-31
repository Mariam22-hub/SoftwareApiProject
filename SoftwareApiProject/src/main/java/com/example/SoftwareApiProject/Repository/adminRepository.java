package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.*;
import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Models.Admin.allTransactions;
import static com.example.SoftwareApiProject.Repository.userRepository.usersArray;


@Service
public class adminRepository {
    public static ArrayList<Transactions> transactionPays = new ArrayList<>();
    public static ArrayList<AddWalletTransactions> walletTransactions = new ArrayList<>();
    public static overall overallDiscount = new overall();
    public static specific specific= new specific();

    @Autowired
    public servicesProvidersRepository servicesRepo;

    public ArrayList<Transactions> findAllRefund() {

            return allTransactions;
    }


    public String updateUserRefund(int transId, int refundState) {
        Transactions refundTrans = null;

        for (int i=0; i<allTransactions.size(); i++){
            if(allTransactions.get(i).getId() == transId){
                refundTrans = allTransactions.get(i);
                break;
            }
        }
        String userName = refundTrans.getUser();
        User user = null;
        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {
                user = users;
                break;
            }
        }

        if(refundState == 1) {
            for (int i = 0; i < user.transactionPay.size(); i++) {

                if (user.transactionPay.get(i).getService().getName().equals(refundTrans.getService().getName())) {

                    user.transactionPay.get(i).setRefunded(true);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);

                    allTransactions.remove(refundTrans);

//                    user.refundTransactions.remove(refundTrans);
                    user.getCreditCard().increment(user.transactionPay.get(i).getService().getPrice());

                    return "user request accepted";
                }
            }
        }
        else {
            for (int i = 0; i < user.transactionPay.size(); i++) {

                if (user.transactionPay.get(i).getService().getName().equals(refundTrans.getService().getName())) {

                    user.transactionPay.get(i).setRefunded(false);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);

                    allTransactions.remove(refundTrans);

                    return "request rejected";
                }
            }
        }
        return "";
    }
    public ArrayList<Transactions> userPayTrans(String userName) {

        ArrayList<Transactions>userTrans = new ArrayList<>();

        for (int i=0;i<transactionPays.size();i++) {
            if (transactionPays.get(i).getUser().equals(userName)) {
                userTrans.add(transactionPays.get(i));
            }
        }

        if(userTrans!= null){
            return userTrans;
        }
        return  null;
    }

    public ArrayList<AddWalletTransactions> userWalletTrans(String userName) {

        ArrayList<AddWalletTransactions> userWalletTrans = new ArrayList<>();
        User user = null;

        for (int i=0;i<walletTransactions.size();i++) {
            if (walletTransactions.get(i).username.equals(userName)) {
                userWalletTrans.add(walletTransactions.get(i));
            }
        }

        if(userWalletTrans!= null){
            return userWalletTrans;
        }
        return  null;
    }

    public ArrayList<Transactions> listUserRefundReq(String userName) {
        User user = null;

        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {
                user = users;
                break;
            }
        }
        return user.refundTransactions;
    }

    public String addProvider(Services service) {
        servicesRepo.insert(service);
        return "service " + service.getName() + " is added to the list of service providers";
    }
}
