package com.example.SoftwareApiProject.Models.Internet;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InternetEtisalat implements Services {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();

	public Payment payment;
	String name;
	double price;
	public InternetEtisalat() {
		name = "InternetEtisalat";;
		price = 190;
	}

	@Override
	public double pay() {
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	@Override
	public String description() {
		return null;
	}

	@Override
	public void setPayment(Payment payMethod) {
		this.payment = payMethod;
	}


}
