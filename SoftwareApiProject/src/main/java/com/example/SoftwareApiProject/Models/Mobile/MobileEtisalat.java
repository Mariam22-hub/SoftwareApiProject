
package com.example.SoftwareApiProject.Models.Mobile;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MobileEtisalat extends Services {

	String ServiceName = "MobileEtisalat";
	public double price = 250;
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
		return null;
	}


	public MobileEtisalat(){}

	public String description() {
		// TODO Auto-generated method stub
		return "welcome to the services of " + this.ServiceName;
	}


}
