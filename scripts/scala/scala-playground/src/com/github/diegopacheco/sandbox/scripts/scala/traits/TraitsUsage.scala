package com.github.diegopacheco.sandbox.scripts.scala.traits

trait Timmer {
   def start() : Unit = { println( System.currentTimeMillis() / 60 ) }
}

object Timmer extends Timmer{
	override def start() : Unit = { println("starting...") }
}

object TraitsUsage{
	def main(args: Array[String]) {
		Timmer.start()
	}
}