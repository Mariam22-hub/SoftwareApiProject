package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.AddWalletTransactions;
import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.User;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.SoftwareApiProject.Models.Admin.allTransactions;
import static com.example.SoftwareApiProject.Repository.userRepository.usersArray;


@Service
public class adminRepository {
    ArrayList<Objects> history = new ArrayList<>();
    public static overall overallDiscount = new overall();

    public ArrayList<Transactions> findAllRefund() {
        if(allTransactions.size() > 0){
            return allTransactions;
        }
        return null;
    }



    public String updateUserRefund(int transId, int refundState) {
        String userName = allTransactions.get(transId).getUser();
        User user = null;
        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {

                user = users;
                break;
            }
        }
        if(refundState == 1) {
            for (int i = 0; i < user.transactionPay.size(); i++) {
                if (user.transactionPay.get(i).getService().getName().equals(allTransactions.get(transId).getService().getName())) {
                    user.transactionPay.get(i).setRefunded(true);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);
                    allTransactions.remove(allTransactions.get(transId));

                    return "user request accepted";
                }
            }
        }
        else {
            for (int i = 0; i < user.transactionPay.size(); i++) {
                if (user.transactionPay.get(i).getService().getName().equals(allTransactions.get(transId).getService().getName())) {
                    user.transactionPay.get(i).setRefunded(false);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);
                    allTransactions.remove(allTransactions.get(transId));
                    return "request rejected";
                }
            }
        }
        return "";
    }
    public ArrayList<Transactions> userPayTrans(String userName) {
        User user = null;
        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {

                user = users;
                break;
            }
        }

        if(user != null){
            return user.transactionPay;
        }
        return  null;
    }



    public static specific specific= new specific();


    public ArrayList<AddWalletTransactions> userWalletTrans(String userName) {
        User user = null;
        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {

                user = users;
                break;
            }
        }

        if(user != null){
            return user.WalletTransactions;
        }
        return  null;
    }
}
