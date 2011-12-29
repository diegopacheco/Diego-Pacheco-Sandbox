package com.github.diegopacheco.sandbox.scripts.scala.basic.varargs

object VarargsMain extends App {
	
	def sumItAll(vs:Int*):Int = vs.foldLeft(0)(_+_) 
	
  	println( sumItAll(1,2,3,4,5) ) 
  
}