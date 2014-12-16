package com.github.diegopacheco.sandbox.scala.akka.actor.remoting

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import com.github.diegopacheco.sandbox.scala.akka.util.Try

object RemoteActorSimpleAppAnotherJVMProcess extends App {
  
   val customConf = ConfigFactory.parseString("""
      akka {
        actor {
          provider = "akka.remote.RemoteActorRefProvider"
      
        }
        remote {
          enabled-transports = ["akka.remote.netty.tcp"]
          netty.tcp {
            hostname = "127.0.0.1"
            port = 2553
          }
       }
      }
   """)
  
   val system = ActorSystem("RemoteActorSimpleASSystem2",ConfigFactory.load(customConf))
   
   Try.it() { () =>
      val actorSelecion = system.actorSelection("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552/user/sampleRemnoteActor")
      println(actorSelecion)
      actorSelecion ! "Works from other actor system"
   }
  
}