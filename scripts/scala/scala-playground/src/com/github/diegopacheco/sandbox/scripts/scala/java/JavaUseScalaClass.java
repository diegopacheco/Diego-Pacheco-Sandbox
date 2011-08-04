package com.github.diegopacheco.sandbox.scripts.scala.java;

public class JavaUseScalaClass {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Diego Pacheco");
		p.setAge(26);

		String toStringResult = p.toString() + " | Java add some string!";
		p.show(toStringResult);
	}
	
}
