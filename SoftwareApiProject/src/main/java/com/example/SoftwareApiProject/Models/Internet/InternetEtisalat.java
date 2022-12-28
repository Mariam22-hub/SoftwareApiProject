package com.example.SoftwareApiProject.Models.Internet;

import java.lang.annotation.Annotation;

public class InternetEtisalat implements Internet {

	public String name = "Internet Etisalat";
	public double price = 190;


	public InternetEtisalat(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public InternetEtisalat(){}

	public String description() {

		return "welcome to the services of " + this.name;
	}

	@Override
	public String value() {
		return null;
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}



}
