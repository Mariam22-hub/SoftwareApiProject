
package com.example.SoftwareApiProject.Models.Donations;

import com.example.SoftwareApiProject.Models.Payment.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CancerHospitals implements Services {

	public String name = "CancerHospitals";
	public double price = 1500;
	public Payment p = null;
	public static ArrayList<User> usersSubscribed = new ArrayList<User>();
	public CancerHospitals(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}
	public void addToArray( User user)
	{
		usersSubscribed.add(user);
	}
	public double DiscountPercentage = 100;
	@Override
	public double getDiscountPercentage() {
		return DiscountPercentage;
	}

	@Override
	public void setDiscountPercentage(double discountPercentage) {
		DiscountPercentage = 100-discountPercentage;
	}
	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public CancerHospitals(){}

	public double pay() {
		return p.pay(price); 
	}


	public String description() {
		// TODO Auto-generated method stub
		return "welcome to the services of " + this.name; 
	}



	public void setPayment(Payment p) {
		this.p = p;
	}
	
	

}
