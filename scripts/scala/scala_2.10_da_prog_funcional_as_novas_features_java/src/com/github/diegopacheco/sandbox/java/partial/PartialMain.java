package com.github.diegopacheco.sandbox.java.partial;

public class PartialMain {
	
	public static Integer soma(Integer a, Integer b){
		return a + b;
	}
	
	interface Partial{
		public Integer get();
	}
	
	public static Integer soma2(Partial b){
		return soma(2,b.get());
	}
	
	public static void main(String[] args) {
		System.out.println(
			
			soma2(new Partial(){
				public Integer get() {
					return 2;
				}
			})
			
		);
	}
	
}

