
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Discounts.Discounts;
import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MobileEtisalat implements Services {

	String ServiceName = "MobileEtisalat";
	public double price = 250;
	public static ArrayList<User> usersSubscribed = new ArrayList<User>();
	Payment p;
	public double pay() {
		return p.pay(price);
	}
	public String getName() {
		return this.ServiceName;
	}

	@Override
	public double getPrice() {
		return price;
	}
	public double DiscountPercentage = 100;
	public double getDiscountPercentage() {
		return DiscountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		DiscountPercentage = 100-discountPercentage;
	}
	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public MobileEtisalat(){}

	public String description() {
		// TODO Auto-generated method stub
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
