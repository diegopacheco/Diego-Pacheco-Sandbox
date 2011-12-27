package com.github.diegopacheco.sandbox.scripts.scala.basic.oo

object EitherMain{
  
	def divide(a:Int,b:Int):Either[String,Int] = {
		try{
		  Right( a / b )
		}catch{
		  case _ => Left("Error")
		}	
		
	}
  
	def main(args: Array[String]) {
		println(divide(0,0))
		println(divide(10,2))
	}
}