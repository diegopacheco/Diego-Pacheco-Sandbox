package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.BalancingPool
import akka.actor.ActorRef
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.routing.FromConfig

object SimpleBalancingPoolRouter extends App {
  
  // CODE Version
  
  val system = ActorSystem("SimpleBalancingPoolRouterAS")
  val actorRouter:ActorRef =  system.actorOf(BalancingPool(5).props(Props[GenericActor]), "routerBalancer")
  
  Try.it() { () =>
      actorRouter ! "hi"
      actorRouter ! "hi"
      actorRouter ! "hi"
  }
  
}