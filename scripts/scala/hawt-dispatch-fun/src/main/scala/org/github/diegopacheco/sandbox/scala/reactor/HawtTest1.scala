package org.github.diegopacheco.sandbox.scala.reactor

import _root_.org.fusesource.hawtdispatch._

object HawtTest1 {
	def run = {
	   val queue = createQueue("qtask")
	   
	   queue {
		   System.out.println("Hi!")
	   }
	   
	   queue.execute(^{
		  System.out.println("Ho!");
	   })
	   
	   println(queue)
	}
	def main(args: Array[String]) = run   
}