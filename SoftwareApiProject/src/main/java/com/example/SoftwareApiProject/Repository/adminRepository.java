package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Objects;

public class adminRepository {
    ArrayList<Objects> history = new ArrayList<>();
    public static overall overallDiscount = new overall(0);
}
