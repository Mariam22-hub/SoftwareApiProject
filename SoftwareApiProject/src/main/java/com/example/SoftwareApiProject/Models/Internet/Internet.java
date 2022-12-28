package com.example.SoftwareApiProject.Models.Internet;

//import Payment.Payment;
//import Services.IFormHandler;
//import Services.Services;

import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface Internet extends Service {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();

	public String name = "";
	public double price = 0;
//	public void setPayment (Payment p);
	public String description ();
//	public void setHandler(IFormHandler Handler);
//	public double pay();

}

