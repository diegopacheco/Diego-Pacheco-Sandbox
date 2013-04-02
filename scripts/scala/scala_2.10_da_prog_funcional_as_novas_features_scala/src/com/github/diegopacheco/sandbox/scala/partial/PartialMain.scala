package com.github.diegopacheco.sandbox.scala.partial

object PartialMain extends App {
	
  def soma(a:Int,b:Int):Int = { 
    a + b 
  } 
  
  val soma2 = soma(2, _:Int)
  
  println( soma2(2) ) 
  
}