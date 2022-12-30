
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public class MobileOrange implements Services {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();
	String ServiceName = "MobileOrange";
	public double price = 300;
	Payment p;
	public double pay() {
		return p.pay(price);
	}
	public String getName() {
		return this.ServiceName;
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

	public MobileOrange(){}
	
	public String description() {
		// TODO Auto-generated method stub
		return "welcome to the services of " + this.ServiceName + "\n";
	}

	@Override
	public void setPayment(Payment payMethod) {
		p = payMethod;
	}


}
