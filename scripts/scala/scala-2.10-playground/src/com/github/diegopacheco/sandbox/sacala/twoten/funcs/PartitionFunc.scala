package com.github.diegopacheco.sandbox.sacala.twoten.funcs

case class Person(name:String = "",age:Int = 0)

object PartitionFunc extends App {
		
	val people:List[Person] = List(new Person("diego",28),new Person("shooter",17))
	
	val (minors, adults) = people partition ( _.age < 18)
	
	println("Adults :" + adults + ", minors: " + minors)	
  
}