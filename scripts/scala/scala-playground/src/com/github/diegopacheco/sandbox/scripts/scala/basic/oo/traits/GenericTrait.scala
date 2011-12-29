package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits

trait Printable{
   type Z
   def print(v:Z):Unit
}

class ScalaPrinter extends Printable{
   type Z = String
   def print(s:String):Unit = println(s)
}

object GenericTrait {
	def main(args: Array[String]) {
		val printer = new ScalaPrinter
		printer.print("Test String")
	}
}