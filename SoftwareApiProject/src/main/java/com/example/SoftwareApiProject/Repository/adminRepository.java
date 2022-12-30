package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class adminRepository {
    ArrayList<Objects> history = new ArrayList<>();
    public static overall overallDiscount = new overall();
    public static specific specific= new specific();
}
