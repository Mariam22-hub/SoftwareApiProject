package com.example.SoftwareApiProject.Models.Internet;

//import Payment.Payment;
//import Services.IFormHandler;
//import Services.Services;

import org.springframework.stereotype.Service;

public interface Internet extends Service {

	public String name = "";
	public double price = 0;
//	public void setPayment (Payment p);
	public String description ();
	public String getName();
//	public void setHandler(IFormHandler Handler);
//	public double pay();

}

