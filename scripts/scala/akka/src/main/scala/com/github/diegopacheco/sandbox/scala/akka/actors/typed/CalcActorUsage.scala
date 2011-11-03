package com.github.diegopacheco.sandbox.scala.akka.actors.typed

import akka.actor._
import akka.actor.TypedActor
import akka.util.duration._

object CalcActorUsage {
  def run = {
    
     val config  = TypedActorConfiguration().timeout(1000 millis)    
     val service = TypedActor.newInstance(classOf[Calculator], classOf[CalcTypedActor], config)
     
     println("Result Multiply 5 * 5: " + service.multiply(5,5).get)
     println("Result division 5 / 5: " + service.division(5,5).get)
     println("Result subtract 5 - 5: " + service.subtract(5,5).get)
     println("Result sum 5 + 5: " + service.sum(5,5).get)
     println("Result sum 5 + 5: " + service.sum(5,5))
     
     TypedActor.stop(service)        
  }  
  def main(args: Array[String]) = run
}