package com.example.SoftwareApiProject.Models.Discounts;

import com.example.SoftwareApiProject.Models.Services;

public class specific extends Discounts {

	double DiscountAmount = 0;
	Services service;
//	private Payment p;

	public specific(double DiscountAmount)
	{	this.DiscountAmount=100-DiscountAmount;

	}

	public specific() {

	}


	public static double pay(Services service, double amount) {
		double pay = (service.getDiscountPercentage()/100) * amount;
		return pay;
	}


//	public void setPayment(Payment p) {
//		this.p = p;
//	}
//


}
