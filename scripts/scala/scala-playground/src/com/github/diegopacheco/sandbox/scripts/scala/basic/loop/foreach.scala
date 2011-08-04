package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

object foreachmain {
  def main(args: Array[String]) {

    println ("foreach to")  
	(5 to 10).foreach(i => println(i + ", "))
	
	println ("foreach List _")
	List(1,2,3).foreach( print(_) )
	
	println ("\nforeach Vector _")
	Vector(1,2,3).foreach( print(_) )

	println ("\nforeach Range _")
	Range(1,3).foreach( print(_) )
	
	println ("\nforeach List i(annonimous func) ")
	List(1,2,3) foreach( i => println ((i*2)) )
	
  }
}