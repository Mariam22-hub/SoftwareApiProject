
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public class MobileVodafone implements Services {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();
	String ServiceName = "MobileVodafone";

	public double price = 400;
	public Payment payment;

	@Override
	public double pay() {
		return 0;
	}

	public String getName() {
		return ServiceName;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public MobileVodafone(){}


	public String description() {
		// TODO Auto-generated method stub
		return "welcome to the services of " + this.ServiceName;
	}

	@Override
	public void setPayment(Payment payMethod) {
		this.payment = payMethod;
	}


}
