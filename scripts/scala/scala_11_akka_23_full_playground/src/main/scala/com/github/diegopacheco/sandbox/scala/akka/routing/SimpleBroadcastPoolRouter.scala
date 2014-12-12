package com.github.diegopacheco.sandbox.scala.akka.routing

import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import com.github.diegopacheco.sandbox.scala.akka.util.Try

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.routing.BroadcastPool

object SimpleBroadcastPoolRouter extends App {
  
  // CODE Version
  
  val system = ActorSystem("SimpleBalancingPoolRouterAS")
  val actorRouter:ActorRef =  system.actorOf(BroadcastPool(5).props(Props[GenericActor]), "routerBroadcaster")
  
  Try.it() { () =>
      actorRouter ! "hi"
      actorRouter ! "hi"
  }
  
}