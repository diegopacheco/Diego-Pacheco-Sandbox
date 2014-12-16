package com.github.diegopacheco.sandbox.scala.akka.actor.remoting

import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import akka.routing.FromConfig

object RemoteActorSimpleApp extends App {
  
  val system = ActorSystem("RemoteActorSimpleAS")
  
  val actor = system.actorOf(Props[GenericActor], "sampleRemnoteActor")
  
  Try.it() { () =>
      actor ! "Pretty slick"
  }
  
  Try.it() { () =>
      val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteActor")
      println(actorSelecion)
      actorSelecion ! "Works"
  }

  
  
}