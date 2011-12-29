package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits

trait Outable[A]{
   def print(v:A):Unit
}

class ScalaOuter[A] extends Outable[A]{
   def print(s:A):Unit = println(s)
}

object GenericTrait2 {
	def main(args: Array[String]) {
		val printer = new ScalaOuter[String]
		printer.print("Test String")
	}
}