package com.github.diegopacheco.sandbox.scala.akka.actor.remoting

import akka.actor.ActorSystem
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.BalancingPool
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor

object RemoteActorSimpleApp extends App {
  
  val system = ActorSystem("RemoteActorSimpleAS")
  val actor = system.actorOf(Props[GenericActor], "sampleRemnoteActor")

  
  Try.it() { () =>
      actor ! "Pretty slick"
  }
  
  
}