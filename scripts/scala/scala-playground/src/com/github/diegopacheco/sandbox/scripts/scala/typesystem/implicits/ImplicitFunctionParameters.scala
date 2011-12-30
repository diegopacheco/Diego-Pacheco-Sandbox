package com.github.diegopacheco.sandbox.scripts.scala.typesystem.implicits

object ImplicitFunctionParameters extends App {
	
	def multiplier(i:Int)(implicit factor:Int){
		println(i * factor)
	}
	
	implicit val factor = 2
	
	multiplier(2)(3)
	multiplier(2)
	
}