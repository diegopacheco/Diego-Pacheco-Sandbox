package com.github.diegopacheco.sandbox.scala.curriyng

object CurriyngMain extends App {
	
  def multiplica(a:Int)(b:Int):Int = a * b
  
  println( multiplica(10)(5) )
  
}

