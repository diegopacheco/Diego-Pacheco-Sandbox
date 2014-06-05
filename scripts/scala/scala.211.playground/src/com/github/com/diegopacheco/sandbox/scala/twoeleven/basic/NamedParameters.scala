package com.github.com.diegopacheco.sandbox.scala.twoeleven.basic

object NamedParameters extends App {
	
	object Hello{
		def world(name:String = "", age:Int=0):String = {
		    return "Hello: " + name + age
		}
	}
	
	println( Hello.world(name = "Diego") )
    
}