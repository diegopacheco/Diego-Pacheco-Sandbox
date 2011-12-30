package com.github.diegopacheco.sandbox.scripts.scala.pattern.matching

object FunWithTyperMatcher extends App {
	
	val friends = List("Poletto","Christophe","Jeferson")
	val empty   = List()
	val coders  = List("Jackson","Jose","Andre")
	
	for(l <- List(friends,empty,coders)){
		l match {
			case List(_,"Christophe",_) => println("Ha French")
			case List(_*) => println("others...")
		}	 
	}
  
}