package com.blogspot.diegopacheco.sandbox.github.java.akka.typed;

import akka.actor.TypedActor;

/**
 * 
 * MainTest 
 *
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		
		HotelBook hotel = (HotelBook) TypedActor.newInstance(HotelBook.class, ChickHotel.class, 1000);
		
		hotel.register("Diego Pacheco");
		People p = hotel.checkOut("Diego Pacheco");
		System.out.println(p);
		
	}
	
}
