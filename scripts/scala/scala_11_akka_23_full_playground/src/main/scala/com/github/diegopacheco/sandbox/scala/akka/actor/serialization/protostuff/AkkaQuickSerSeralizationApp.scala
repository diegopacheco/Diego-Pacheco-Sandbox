package com.github.diegopacheco.sandbox.scala.akka.actor.serialization.protostuff

import akka.actor.{ActorRef, ActorSystem, Props}
import com.github.diegopacheco.sandbox.scala.akka.util.{GenericActor, Try}

case class QuickSerMessage(msg: String)

object AkkaQuickSerSeralizationApp extends App {

  val system = ActorSystem("RemoteActorSimpleAS")

  val actor: ActorRef = system.actorOf(Props[GenericActor], "sampleRemnoteQuickSerActor")

  Try.that() {
    actor ! QuickSerMessage("Pretty awesome")

    val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteQuickSerActor")
    println(actorSelecion)
    actorSelecion ! QuickSerMessage("Works")

  }

}
