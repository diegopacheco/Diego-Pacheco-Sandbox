package com.github.diegopacheco.sandbox.java8.lambdas.collections.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsMain {
	
	public static void main(String[] args) {
		
		 List<Person> pessoas = new ArrayList<Person>();
		 
		 pessoas.add(new Person("Diego Pacheco", 30));
		 pessoas.add(new Person("Martin", 40));
		 pessoas.add(new Person("Neymar Jr", 22));
		 pessoas.add(new Person("Gandalfi", 1));
		 
		 int sumOfAges = pessoas.stream()
				 		 .filter( p -> p.getAge() >= 18)
				 		 .mapToInt( p -> p.getAge() )
				 		 //.parallel()
				 		 .sum();
		 
		 System.out.println("Sum of all people more than 18: " + sumOfAges);
		 
	}
	
}
