package com.github.diegopacheco.sandbox.scala.akka.actor.serialization.protostuff

import akka.actor.ActorSystem
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorRef

case class ProtoBuffMessage(msg:String)

object AkkaProtostuffSerializationApp extends App {
  
   val system = ActorSystem("RemoteActorSimpleAS")
   
   val actor:ActorRef = system.actorOf(Props[GenericActor], "sampleRemnoteProtobuffActor")
   
   Try.that() { 
       actor ! ProtoBuffMessage("Pretty awesome")
       
       val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteProtobuffActor")
       println(actorSelecion)
       actorSelecion ! ProtoBuffMessage("Works")
       
   }

}