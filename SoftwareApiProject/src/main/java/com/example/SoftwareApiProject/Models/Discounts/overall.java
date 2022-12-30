package com.example.SoftwareApiProject.Models.Discounts;

import com.example.SoftwareApiProject.Models.Payment;
import com.example.SoftwareApiProject.Models.Services;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class overall extends Discounts {

//	Services service;
//
	double DiscountAmount = 0;
//

//	private Payment p;

	boolean flag = false;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public overall(double DiscountAmount)
	{	this.DiscountAmount=DiscountAmount;
//		this.service = service;
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
