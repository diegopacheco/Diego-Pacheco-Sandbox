package org.github.diegopacheco.sandbox.scala.reactor

import java.util.concurrent.Semaphore
import _root_.org.fusesource.hawtdispatch._

object HawtSemaphore {
  def run = {
    val done = new Semaphore(1 - (1000 * 1000))

    val queue = createQueue()
    val source = createSource(EventAggregators.INTEGER_ADD, queue)
    source.onEvent {
      val count = source.getData()
      println("got: " + count)
      done.release(count.intValue)
    }
    source.resume();

    // Produce 1,000,000 concurrent merge events
    for (i <- 0 until 1000) {
      globalQueue {
        for (j <- 0 until 1000) {
          source.merge(1)
        }
      }
    }

    // Wait for all the event to arrive.
    done.acquire()
  }
  def main(args: Array[String]) = run
}