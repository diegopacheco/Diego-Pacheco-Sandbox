package com.github.diegopacheco.sandbox.scripts.scala.basic.oo

import scala.reflect._

class Numero(
    @BeanProperty var valor: Int = 0
){
	def + (that:Int) = that + this.valor
	def - (that:Int) = this.valor - that
}

object MathOverload {
  def main(args : Array[String]) : Unit = {
	   
	   val v1 		  = new Numero(5)
	   val resultPlus = v1 + 5
	   val resultMin  = v1 - 2
	   
	   Console.print("5 + 5 = " + resultPlus + "\n")
	   Console.print("5 - 2 = " + resultMin + "\n")
  }
}
