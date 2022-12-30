package com.example.SoftwareApiProject.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@NoArgsConstructor
@Data
public class Admin {

    String name = "admin";
    String password = "admin";

    public static ArrayList<Transactions> allTransactions = new ArrayList<Transactions>();




}
