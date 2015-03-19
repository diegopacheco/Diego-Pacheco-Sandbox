package com.github.diegopacheco.sandbox.java.gdrl.guice;

import javax.inject.Inject;

import com.github.diegopacheco.sandbox.java.gdrl.guice.logger.InfoLogger;

public class BillingService {

    private Payment payment;
    private InfoLogger logger;

    @Inject
    public BillingService(Payment payment,InfoLogger logger){
        this.payment = payment;
        this.logger = logger;
    }
    
    public Boolean bill(Integer id){
    	logger.info("Billing for " + id);
    	Boolean result = payment.pay(id, 10.0);
    	logger.info("Billing result for { " + id + ", 10.00 } = " + result);
    	return result;
    }

}
