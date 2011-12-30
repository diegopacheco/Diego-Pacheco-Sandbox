package com.github.diegopacheco.sandbox.scripts.scala.basic.oo

object SealedCaseClassFun extends App {
	
	sealed case class BadGuy
	sealed case class TheJoker(name:String,enemy:String) extends BadGuy{
		override def toString():String = name + " :-> " + enemy 
	}
	
	val coringa = new TheJoker("Curinga","Batima")
	println( coringa ) 
  
}