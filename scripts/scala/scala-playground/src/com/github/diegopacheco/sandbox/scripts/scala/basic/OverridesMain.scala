package com.github.diegopacheco.sandbox.scripts.scala.basic

object OverridesMain extends App {
	
	class StringNumber(@scala.reflect.BeanProperty var v:String){
	   def +(other:StringNumber):StringNumber = {
	      val result = v.toInt + other.v.toInt
	      new StringNumber(result.toString())
	   }
	   override def toString:String = v.toString()
	}
	
	val n1 = new StringNumber("10")
	val n2 = new StringNumber("10")
	
	val r1 = n1 + n2
	println(r1)
  
}