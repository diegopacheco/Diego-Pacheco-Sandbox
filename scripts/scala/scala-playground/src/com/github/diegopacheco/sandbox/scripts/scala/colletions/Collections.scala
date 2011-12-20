package com.github.diegopacheco.sandbox.scripts.scala.colletions

object Collections {
	def run {
	    println("*** Lists: ")
		lists	
		
		println("*** Sets: ")
		sets
		
		println("*** Tuples: ")
		tuples		
		
		println("*** Maps: ")
		maps
		
		println("*** Options: ")
		options
	}	
	def lists{
	    val numbers = List(1, 2, 3, 4)
		println(numbers)
	}	
	def sets{
	    val numbers = Set(1, 2, 3, 4)
		println(numbers)
	}	
	def tuples{
	   var config = ("localhost", 80, false)
	   println(config)
	   println(config -> 1)
	   println( "x" -> "y")
	   println( "x" -> "y" -> "z" )
	}
	def maps{
	   var mapa = Map(1 -> 2, "RS" -> "POA")
	   println(mapa)
	}
	def options{
	    val numbers = Map(1 -> "one", 2 -> "two")
	    println( numbers.get(2) )
	    println( numbers.get(3) )
	}
	def main(args: Array[String]) = run
}