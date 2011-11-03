package org.github.diegopacheco.sandbox.scala.reactor

import java.util.concurrent.TimeUnit._
import collection.JavaConversions._
import _root_.org.fusesource.hawtdispatch._

object HawtMonitor {
     
	def monitor_hawtdispatch:Unit = {
	    getGlobalQueue(){
	      //println(Dispatch.metrics)
	      Dispatch.metrics.foreach{ metric =>
	        if( metric.totalWaitTimeNS > MILLISECONDS.toNanos(10)) {
	          println("Dispatch queue haveing slow wait time: "+metric)
	        }
	        if( metric.totalRunTimeNS > MILLISECONDS.toNanos(10)) {
	          println("Dispatch queue haveing long rune time: "+metric)
	        }
	      }
	      monitor_hawtdispatch
	    }
	}  
    def run {
	   var queue = globalQueue
	   queue.profile(true)
	   
	   for(i  <- 1 until 1000){	     
	     queue.execute(^{
		   System.out.println("Hey " + i)
		   Thread.sleep(10)
	     })	     
	   }
	   monitor_hawtdispatch
	   Thread.sleep(60000)
    }
	def main(args: Array[String]) = run 
}