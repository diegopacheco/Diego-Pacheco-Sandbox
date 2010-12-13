package com.blogspot.diegopacheco.sandbox.github.java.akka.typed;

/**
 * 
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 * 
 */
public interface HotelBook {
	
	public void register(String peopleName);
	public People checkOut(String name);
	
}
