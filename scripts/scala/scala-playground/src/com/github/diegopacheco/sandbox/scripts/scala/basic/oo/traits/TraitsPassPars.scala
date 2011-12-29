package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits

object TraitsPassPars extends App {
	
	abstract class Human(name:String){
		override def toString():String = name
	}	
	class Person(var name:String) extends Human(name)	
	class Coder(name:String) extends Person(name)
	
	val diego = new Coder("Diego")
	println(diego)
	
}