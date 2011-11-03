package org.github.diegopacheco.sandbox.scala.reactor

import _root_.org.fusesource.hawtdispatch._

object HawtExecutors {
  def run {
    
    val executor = java.util.concurrent.Executors.newSingleThreadExecutor()
    executor {
      println("This block is run async on the exectutor");
    }
    
    val executor2 = java.util.concurrent.Executors.newCachedThreadPool()
    executor2 {
      println("2.1");
    }
    executor2 {
      println("2.2");
    }
    executor2 {
      println("2.3");
    }
    
  }
  def main(args: Array[String]) = run
}