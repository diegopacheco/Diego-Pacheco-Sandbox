package com.github.diegopacheco.sandbox.scripts.scala.currying

object CurryingFunctions {
	
	def times(n:Int)(f: => Unit) = for(i <- 1 to n){ f }
	
	def main(args: Array[String]) {
		times(5){ 
		   println("Hey")
		}
	}
}