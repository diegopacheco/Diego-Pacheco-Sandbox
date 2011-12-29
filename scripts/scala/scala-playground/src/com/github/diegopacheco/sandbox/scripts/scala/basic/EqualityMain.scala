package com.github.diegopacheco.sandbox.scripts.scala.basic

object EqualityMain extends App {
	
	var x:Int = 10
	var y:Int = 20
	var z:Int = y
	
	println( " x == y | " + (x == y) ) // false
	println( " z == y | " + (z == y) ) // true
	
	case class Person(var name:String)
	
	var p1 = Person("Diego")
	var p2 = Person("Oderkey")
	var p3 = Person("Diego")
	var p4 = p1
	
	println( "p1 == p2 | " + (p1 == p2) ) // false
	println( "p1 == p3 | " + (p1 == p3) ) // true
	println( "p1 == p4 | " + (p1 == p4) ) // true
	
	println( "p1 eq p2 | " + (p1 eq p2) ) // false
	println( "p1 eq p3 | " + (p1 eq p3) ) // false
	println( "p1 eq p4 | " + (p1 eq p4) ) // true
  
}