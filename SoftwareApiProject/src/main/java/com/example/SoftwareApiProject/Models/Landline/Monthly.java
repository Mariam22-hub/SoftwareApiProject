
package com.example.SoftwareApiProject.Models.Landline;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Monthly implements Services {

	public String name = "Monthly";
	public double price = 800;
	public Payment p = null;

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();

	public double DiscountPercentage = 100;

	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getDiscountPercentage() {
		return DiscountPercentage;
	}

	@Override
	public void setDiscountPercentage(double discountPercentage) {
		this.DiscountPercentage = discountPercentage;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}

	public Monthly(){};

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
