package com.example.SoftwareApiProject.Models.Discounts;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
//@AllArgsConstructor
public class overall extends Discounts {

//	Services service;
//
	public double DiscountAmount;

	Payment p;
	boolean flag = false;

	public overall(double discountAmount, Payment p, boolean flag) {
		DiscountAmount = discountAmount;
		this.p = p;
		this.flag = flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public overall(double DiscountAmount)
	{	this.DiscountAmount=100-DiscountAmount;
		this.flag = true;
	}

//	@Override
	public double pay(Services service) {
			double pay = service.pay() * (DiscountAmount / 100);
			System.out.println("Paid amount after discount: " + pay + "\n");
			return pay;
	}

	@Override
	public void setPayment(Payment p) {
		this.p = p;
	}


}
