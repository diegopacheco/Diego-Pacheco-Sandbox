package com.github.diegopacheco.sandbox.scripts.scala.basic

class Lazy {
	def lazyy2(o: => Any) = println(o)
}

object LazyMain{
     def main(args : Array[String]) : Unit = {
    	lazy val l = new Lazy
    	l.lazyy2("teste") 
     }
}