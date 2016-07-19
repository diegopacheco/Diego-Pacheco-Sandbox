package com.github.diegopacheco.sandbox.java.junit.runner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class SimpleRunner extends BlockJUnit4ClassRunner{

	public SimpleRunner(Class<?> klass) throws InitializationError {
		super(klass);
		System.out.println(klass);
	}
	
	
	
}
