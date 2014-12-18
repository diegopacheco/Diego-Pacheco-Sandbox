package com.github.diegopacheco.sandbox.scala.akka.actor.serialization.protostuff

import akka.actor.{ActorRef, ActorSystem, Props}
import com.github.diegopacheco.sandbox.scala.akka.util.{GenericActor, Try}

case class KryoMessage(msg: String)

// classloading issues with reflectASM and kryo 2.2.4
object AkkaKryoSeralizationApp extends App {

  val system = ActorSystem("RemoteActorSimpleAS")

  val actor: ActorRef = system.actorOf(Props[GenericActor], "sampleRemnoteKryoActor")

  Try.that() {
    actor ! KryoMessage("Pretty awesome")

    val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteKryoActor")
    println(actorSelecion)
    actorSelecion ! KryoMessage("Works")

  }

}
