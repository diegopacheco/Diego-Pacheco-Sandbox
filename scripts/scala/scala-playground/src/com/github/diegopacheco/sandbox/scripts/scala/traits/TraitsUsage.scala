package com.github.diegopacheco.sandbox.scripts.scala.traits

trait Timmer {
   def start() : Unit = { println( System.currentTimeMillis() / 60 ) }
}

trait Logger {
   def info(msg: String) : Unit = { println( msg ) }
}

trait Byer {
   def bye() : Unit = { println("bye") }
}

object Timmer extends Timmer with Logger with Byer{
	def doit(msg: String) : Unit = {
		start()
		info(msg)
		bye()
	}
}

object TraitsUsage{	  
  def main(args : Array[String]) : Unit = {
	  Timmer.doit("Start")
  }
}