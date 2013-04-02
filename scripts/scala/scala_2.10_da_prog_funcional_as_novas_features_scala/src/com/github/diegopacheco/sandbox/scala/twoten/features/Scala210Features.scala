package com.github.diegopacheco.sandbox.scala.twoten.features

// Value Class

object Scala210Features extends App {
	
    class RichInt(val value: Int) extends AnyVal {
    	def toUpperHexString: String = java.lang.Integer.toHexString(value).toUpperCase
    }
    
    val x = new RichInt(2) // at run time, x is simply an integer!
    println( x.toUpperHexString )
    
}

// Better Implicits

trait AwesomeStringImplicits {      	
  
  class AwesomeString(s:String) {
	    def awesome_! = s + "! Awesome!"
  }
  
  implicit def asAwesomeString(s: String) = new AwesomeString(s)
}

object Main extends App with AwesomeStringImplicits {  
  println( "Scala".awesome_! )
}
 

