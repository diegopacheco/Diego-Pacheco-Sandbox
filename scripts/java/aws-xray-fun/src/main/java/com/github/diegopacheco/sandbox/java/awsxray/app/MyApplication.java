package com.github.diegopacheco.sandbox.java.awsxray.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.diegopacheco.sandbox.java.awsxray.rest.CalcController;

@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
	    SpringApplication.run(CalcController.class, args);
	}
}
