package com.github.diegopacheco.sandbox.scripts.scala.basic.oo

object ConstructorThisMain extends App {
	
	class Employee(var name:String){
		
	    var lame:String = null
	  
		def this(name:String,lastName:String){
		   this(name)
		   lame = lastName
		}
	    
	    override def toString():String = "Employee=> " + name + " " + lame
	  
	}
	
	val e1 = new Employee("Diego","Pacheco")
	println(e1)
  
}