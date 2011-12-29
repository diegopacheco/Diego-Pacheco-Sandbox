package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

//
// for([pattern <- generator; definitions*];filter*)
//     [yield] expression
//
object MoreAdvancedFunWithForExpression extends App {
	
	  for(i <- 1 to 5){ print(i) }	
	  
	  val result = for(i <- 1 to 3) yield i * 2	
	  println("\n" + result)
	  
	  val mapped = (1 to 10).map(_ * 2)
	  println(mapped)
	  
	  val doubleEvens = for(i <- 1 to 10; if i % 2 == 0) yield i * 2
	  println(doubleEvens)
	  
	  val curryied = for{
	    i <- 1 to 10
	    if i % 2 == 0
	  } yield i * 2
	  println(curryied)
	  
	  // cartesian product, so cool!
	  for(i <- 1 to 3; j <- 4 to 7){
	      printf("[%d,%d]\n",i,j)
	  }
	  
	  val people = List("Diego","Poletto","Frances","Jeferson")
	  val fourChars = for(person <- people; lchar = person.charAt(4)) yield lchar
	  println(fourChars)
	  
}