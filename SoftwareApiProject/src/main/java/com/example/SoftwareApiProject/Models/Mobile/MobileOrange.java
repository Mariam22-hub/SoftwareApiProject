
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;

import java.util.ArrayList;

public class MobileOrange extends Services {

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
	
	

}
