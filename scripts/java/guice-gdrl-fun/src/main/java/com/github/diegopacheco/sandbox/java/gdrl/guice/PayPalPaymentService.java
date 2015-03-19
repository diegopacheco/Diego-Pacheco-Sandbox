package com.github.diegopacheco.sandbox.java.gdrl.guice;

public class PayPalPaymentService implements Payment {
	public Boolean pay(Integer id,Double value){
		System.out.println("Payment delivered: " + id + " $ " + value);
		return true;
	}
}
