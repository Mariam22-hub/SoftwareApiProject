package com.example.SoftwareApiProject.services.Admin;

import com.example.SoftwareApiProject.Models.Discounts.overall;

public interface adminServices {
    public String addProvider();

    String addOverallDiscount(double percentage);

    String addSpecificDiscount(double percentage, String serviceName);
}
