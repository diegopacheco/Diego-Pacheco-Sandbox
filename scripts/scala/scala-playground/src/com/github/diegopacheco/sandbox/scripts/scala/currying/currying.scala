package com.github.diegopacheco.sandbox.scripts.scala.currying

class Currying {
    // Currying - single arg 
  	def add(x:Int) = (y:Int) => x + y
  	
  	// Currying - other method + "_"
  	def addFiveCurrying = add(5)(_:Int)
  	
  	def soma(x:Int,y:Int) = x + y  	
  	def addFiveNoCurrying = soma(5, _:Int)
}

object CurryingMain {
  def main(args: Array[String]): Unit = {
	  var c = new Currying
	  println( c.add(1)(2) )   					// 3
	  println( c.add(1) )      					// <function1>
	  println( c.addFiveNoCurrying(5) )  		// 10
	  println( c.addFiveCurrying(5) )  			// 10
  }
}
