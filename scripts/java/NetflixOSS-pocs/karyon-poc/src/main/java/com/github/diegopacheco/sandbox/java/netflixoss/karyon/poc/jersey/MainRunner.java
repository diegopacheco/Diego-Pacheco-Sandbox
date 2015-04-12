package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.jersey;

public class MainRunner {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		System.setProperty("archaius.deployment.environment","dev");
		netflix.karyon.KaryonRunner.main(new String[]{KaryonJerseyServerApp.class.getCanonicalName()});
	}
}
