package com.github.diegopacheco.sandbox.java.gdrl.guice;

import javax.inject.Inject;

public class BillingService {

    private Payment payment;

    @Inject
    public BillingService(Payment payment){
        this.payment = payment;
    }
    
    public Boolean bill(Integer id){
    	System.out.println("Billing for " + id);
    	return payment.pay(id, 10.0);
    }

}
