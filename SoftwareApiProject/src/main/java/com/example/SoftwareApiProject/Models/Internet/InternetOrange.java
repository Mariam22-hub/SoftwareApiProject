package com.example.SoftwareApiProject.Models.Internet;//package com.example.SoftwareAPIProject.entity.Internet;

import java.lang.annotation.Annotation;

public class InternetOrange implements Internet {

    public String name = "Internet Etisalat";
    public double price = 190;

    public InternetOrange(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String description() {

        return "welcome to the services of " + this.name;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String value() {
        return null;
    }

}
