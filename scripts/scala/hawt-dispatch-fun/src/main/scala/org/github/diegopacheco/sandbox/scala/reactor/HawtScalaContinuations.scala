package org.github.diegopacheco.sandbox.scala.reactor

import util.continuations._
import _root_.org.fusesource.hawtdispatch._

object Foo2 {
  var held:Int = 0;
  val a = createQueue("aa")
  
  def hold(v:Int) = a ! {
    val rc = held
    held = v
    rc
  }
}

// Issues on Scala 2.9.2-SNAPSHOT NoMethodDefFoundError on: reset
object Bar2 {
  var sum:Int = 2;
  val b = createQueue("bb")
  
  def test = b {
    reset {
      val result = Foo2.hold(sum+5)
      sum += result
      println("sum is at: "+sum)
    }
  }
}

object HawtScalaContinuations {
    def run = {
       Bar2.test
       Thread.sleep(3000)
    }
	def main(args: Array[String]) = run
}