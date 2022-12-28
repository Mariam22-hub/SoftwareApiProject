package com.example.SoftwareApiProject.Models.Internet;

import com.example.SoftwareApiProject.Models.Service;
import com.example.SoftwareApiProject.Models.User;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class InternetEtisalat implements Service {

	public static ArrayList<User> usersSubscribed = new ArrayList<User>();

	String name;
	double price;

	public InternetEtisalat() {
		name = "Internet Etisalat";;
		price = 190;
	}

	@Override
	public String description() {

		return "welcome to the services of " + this.name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<User> getArray() {
		return usersSubscribed;
	}


}
