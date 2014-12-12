package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.BalancingPool
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import akka.routing.SmallestMailboxPool

object SimpleSmallestMailBoxRouterApp extends App {
  
  // CODE Version
  
  val system = ActorSystem("SmallestMailBoxRouterAS")
  val actorRouter:ActorRef =  system.actorOf(SmallestMailboxPool(5).props(Props[GenericActor]), "smallestRouter")
  
  Try.it() { () =>
      actorRouter ! "hi"
      actorRouter ! "hi"
      actorRouter ! "hi"
  } 
  
}