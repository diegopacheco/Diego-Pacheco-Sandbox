package org.github.diegopacheco.sandbox.scala.reactor

import _root_.org.fusesource.hawtdispatch._

object Foo {
  val a = createQueue("a")
  var held:Int = 0;
  
  def hold(v:Int)(result:(Int)=>Unit) = a {
    val rc = held
    held = v
    result( rc )
  }
}

object Bar {
  val b = createQueue("b")
  var sum:Int = 5;
  
  def test = b {
      Foo.hold(sum + 5) { result=>
      b {
        sum += result
        println("sum is at: "+sum)
      }
    }
  }
}

object HawtContinuations {
    def run = {
       Bar.test
       Thread.sleep(4000)
    }
	def main(args: Array[String]) = run
}