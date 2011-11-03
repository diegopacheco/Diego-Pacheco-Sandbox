package org.github.diegopacheco.sandbox.scala.reactor

import org.fusesource.hawtdispatch.Future
import _root_.org.fusesource.hawtdispatch._

object HawtFuture2 {
  
  def createFuture:Future[Double] = {
     createQueue().future {
       (200D * Math.random)
    }
  }
  
  def run {
    val future:Future[Double] = Future.first(List(createFuture, createFuture, createFuture))
    println("first result was: " + future())
  }
  def main(args: Array[String]) = run
}