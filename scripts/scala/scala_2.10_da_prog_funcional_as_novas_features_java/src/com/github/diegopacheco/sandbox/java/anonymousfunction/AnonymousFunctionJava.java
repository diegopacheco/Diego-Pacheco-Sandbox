package com.github.diegopacheco.sandbox.java.anonymousfunction;

public class AnonymousFunctionJava {
	
	interface Add1 {
		public Integer apply(Integer i);
	}
	
	public static void main(String[] args) {
		Add1 add1 = new Add1(){
			@Override
			public Integer apply(Integer i) {			
				return i + 1;
			}
		};
		System.out.println( add1.apply(3) );
	}
}


