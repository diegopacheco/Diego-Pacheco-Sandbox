package com.github.diegopacheco.sandbox.scala.akka.actor.serialization.custom

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.serialization.JSerializer
import com.github.diegopacheco.sandbox.scala.akka.util.{GenericActor, Try}

case class CustonMessage(msg: String)

class MyOwnSerializer extends JSerializer {
  override protected def fromBinaryJava(bytes: Array[Byte], manifest: Class[_]): AnyRef = "hi"
  override def includeManifest: Boolean = false
  override def toBinary(o: AnyRef): Array[Byte] = {
    new Array(Byte.MaxValue)
  }
  override def identifier: Int = 122345678
}

object AkkaCustomJavaSerializationSystemApp extends App {

  val system = ActorSystem("RemoteActorSimpleAS")

  val actor: ActorRef = system.actorOf(Props[GenericActor], "sampleRemnoteCustonActor")

  Try.that() {
    actor ! CustonMessage("Pretty awesome")

    val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteCustonActor")
    println(actorSelecion)
    actorSelecion ! CustonMessage("Works")

  }

}
