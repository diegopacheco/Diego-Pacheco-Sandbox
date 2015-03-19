package com.github.diegopacheco.sandbox.java.gdrl.guice.main;

import com.github.diegopacheco.sandbox.java.gdrl.guice.BillingService;
import com.github.diegopacheco.sandbox.java.gdrl.guice.module.BillingModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainApp {
	public static void main(String[] args) {
	    Injector injector = Guice.createInjector(new BillingModule());
	    BillingService billingService = injector.getInstance(BillingService.class);
	    
	    billingService.bill(6);
	}
}
