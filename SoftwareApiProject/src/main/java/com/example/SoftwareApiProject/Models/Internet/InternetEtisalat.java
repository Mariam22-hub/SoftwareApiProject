package com.example.SoftwareApiProject.Models.Internet;

import java.lang.annotation.Annotation;

public class InternetEtisalat implements Internet {

	public String name = "Internet Etisalat";
	public double price = 190;
//	public Payment p = null;

//	public IFormHandler MyHandler;

//	public void setHandler(IFormHandler Handler)
//	{
//		this.MyHandler = Handler;
//	}


	public InternetEtisalat(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public InternetEtisalat(){}

//	public double pay() {
//		return p.pay(price);
//	}

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


//	public void setPayment(Payment p) {
//		this.p = p;
//	}




}
