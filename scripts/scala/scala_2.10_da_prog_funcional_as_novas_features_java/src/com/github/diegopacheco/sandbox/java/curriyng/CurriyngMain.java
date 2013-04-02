package com.github.diegopacheco.sandbox.java.curriyng;

public class CurriyngMain {
	
	interface Curriyng {
		public Integer curried(Integer b);
	}
	
	class CurriyngImpl implements Curriyng {
		private Integer a = 0;

		public CurriyngImpl(Integer a) {
			this.a = a;
		}
		public Integer curried(Integer b) {
			return a * b;
		}
	}
	
	public Curriyng multiplica(Integer a){
		return new CurriyngImpl(a);
	}
	
	public static void main(String[] args) {
		System.out.println( new CurriyngMain().multiplica(10).curried(5) );
	}
}


