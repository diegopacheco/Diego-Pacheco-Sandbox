package com.github.diegopacheco.sandbox.java.awsxray.app;

import org.springframework.boot.SpringApplication;

import com.github.diegopacheco.sandbox.java.awsxray.rest.CalcController;

public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(CalcController.class, args);
	}
}
