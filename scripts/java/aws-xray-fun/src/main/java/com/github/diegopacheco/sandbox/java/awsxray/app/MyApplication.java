package com.github.diegopacheco.sandbox.java.awsxray.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
	public static void main(String[] args) {
	    new MyApplication().configure(new SpringApplicationBuilder(SpringBootApp.class)).run(args);
	}
}
