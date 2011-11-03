package org.github.diegopacheco.sandbox.scala.reactor

import _root_.org.fusesource.hawtdispatch._

class MyCounter {
    var queue = createQueue("qcounterx")
    var counter = 1
    
    def add(value:Int) = queue.execute(^{
    	counter += value
    }) 
    def sub(value:Int) = queue.execute(^{
      counter -= value
    })
    def get():Int = counter
}

object HawtCounter {
    def run {
      def cnt:MyCounter = new MyCounter()
      cnt.add(10)
      cnt.add(11)
      cnt.add(12)
      cnt.add(13)
      println(cnt.get)
    }
	def main(args: Array[String]) = run
}