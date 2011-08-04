package com.github.diegopacheco.sandbox.scripts.scala.basic.func

class Zipper {
	def zzip():Unit = {
	    val v = Vector(1,2,3,4)
	    var timesTwo = List(2,2,2,2,2,2)
	    
	    println( Vector(1,2,3) zip (Vector(4,5,6)) )
	    println( v.zip(v.map(_ * 2)) )
	    println( v.zip(v.map(timesTwo)) )
	}
}

object AnyMain{
     def main(args : Array[String]) : Unit = {
    	new Zipper().zzip // Vector((1,4), (2,5), (3,6))
     }
}