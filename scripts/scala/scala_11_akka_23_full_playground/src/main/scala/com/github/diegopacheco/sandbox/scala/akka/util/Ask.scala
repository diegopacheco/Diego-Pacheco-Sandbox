package com.github.diegopacheco.sandbox.scala.akka.util

import akka.routing.GetRoutees
import akka.routing.Routees
import scala.concurrent.Await
import akka.actor.Actor
import akka.actor.ActorRef

object Ask {
    
      import scala.concurrent.duration._
      import akka.util.Timeout
      import akka.pattern.ask
  
      implicit val timeout = Timeout(5 seconds) 
      
   def get[T](actor:ActorRef,message:Any):T = {
      val future = actor ? message
      val result:T = Await.result(future, timeout.duration).asInstanceOf[T]
      return result
   }
  
}