package com.github.diegopacheco.sandbox.scripts.scala.pattern.matching

object MethodTypeMatcher extends App {
	
	def whatTodo(on:String):Unit = on match {
	  	case "Monday" => println("Hard Work")
	  	case "Friday" => println("Lazy Work")
	  	case "Saturday" => println("Fun")
	  	case "Sunday" => println("REST")
	  	case _ => println("Code Scala")
	}
	
	val days = List("Monday","Wendsday","Friday","Sunday","Saturday")
	days.foreach( whatTodo )
  
}