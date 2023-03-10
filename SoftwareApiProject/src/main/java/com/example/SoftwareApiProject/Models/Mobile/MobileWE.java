
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public class MobileWE implements Services {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();

	String ServiceName = "MobileWe";

	public double price = 500;
	Payment p;
	public double pay() {
		return p.pay(price);
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return ServiceName;

	}
	public double DiscountPercentage =100;
	public double getDiscountPercentage() {
		return DiscountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		DiscountPercentage = 100-discountPercentage;
	}


	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public MobileWE()
	{}


	public String description() {
		return "welcome to the services of " + this.ServiceName;
	}

	@Override
	public void setPayment(Payment payMethod) {
		p = payMethod;
	}
	public void addToArray( User user)
	{
		usersSubscribed.add(user);
	}

}
