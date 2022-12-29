
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public class MobileOrange implements Services {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();
	String ServiceName = "MobileOrange";
	public double price = 300;
	public Payment payment;

	@Override
	public double pay() {
		return 0;
	}

	public String getName() {
		return this.ServiceName;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public MobileOrange(){}
	
	public String description() {
		// TODO Auto-generated method stub
		return "welcome to the services of " + this.ServiceName + "\n";
	}

	@Override
	public void setPayment(Payment payMethod) {
		this.payment = payMethod;
	}


}
