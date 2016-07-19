package com.github.diegopacheco.sandbox.java.junit.test.runner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.diegopacheco.sandbox.java.junit.runner.SimpleRunner;

@RunWith(SimpleRunner.class)
public class MyRunnerTest {
	
	@Test
	public void testItA(){
		System.out.println("OK A");
	}
	
	@Test
	public void testItB(){
		System.out.println("OK B");
	}
	
	@Test
	public void testItC(){
		System.out.println("OK C");
	}
	
}
