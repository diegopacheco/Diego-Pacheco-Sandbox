package org.github.diegopacheco.sandbox.scala.reactor

import _root_.org.fusesource.hawtdispatch._

object HawtFuture {
  def run = {

    var queue = createQueue("qinc")
    val future: Future[Int] = queue.future {
      var rc = 1;
      for (i <- 1 until 10) {
        rc *= i
      }
      rc
    }

    future.onComplete( 
    	(i: Int) => System.out.println("computation completed " + i) 
    )
    
    while(!future.completed){
      Thread.sleep(2000)
    }

  }
  def main(args: Array[String]) = run
}