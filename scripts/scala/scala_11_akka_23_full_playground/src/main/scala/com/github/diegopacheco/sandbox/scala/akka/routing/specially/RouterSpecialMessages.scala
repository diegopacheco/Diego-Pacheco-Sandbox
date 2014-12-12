package com.github.diegopacheco.sandbox.scala.akka.routing.specially

import akka.actor.ActorRef
import akka.actor.ActorSystem
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.Props
import akka.routing.BalancingPool
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import akka.routing.Broadcast
import akka.actor.PoisonPill
import akka.actor.Kill
import akka.routing.GetRoutees
import scala.concurrent.Await
import akka.routing.Routees
import com.github.diegopacheco.sandbox.scala.akka.util.Ask

object RouterSpecialMessages extends App {
      
  val system = ActorSystem("RouterSpecialMessagesAS")
  val actorRouter:ActorRef =  system.actorOf(BalancingPool(5).props(Props[GenericActor]), "actorRouterSpecially")
  
  Try.it() { () =>
       
      val routees:Routees = Ask.get[Routees](actorRouter, GetRoutees) // AddRoutee, RemoveRoutee, AdjustPoolSize  
      println(routees)
    
      actorRouter ! Broadcast("hi")
      actorRouter ! Broadcast(PoisonPill)
      actorRouter ! Broadcast(Kill)
  }
  
}