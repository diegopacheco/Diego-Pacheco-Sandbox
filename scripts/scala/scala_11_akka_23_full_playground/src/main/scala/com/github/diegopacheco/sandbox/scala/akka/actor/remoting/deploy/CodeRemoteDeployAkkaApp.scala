package com.github.diegopacheco.sandbox.scala.akka.actor.remoting.deploy

import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import akka.actor.ActorSystem

object CodeRemoteDeployAkkaApp extends App {
  
    import akka.actor.{ Props, Deploy, Address, AddressFromURIString }
    import akka.remote.RemoteScope
    
    val system = ActorSystem("RemoteActorSimpleAS")
    
    val one = AddressFromURIString("akka.tcp://RemoteActorSimpleAS@127.0.0.1:2552")
    val two = Address("akka.tcp", "RemoteActorSimpleAS", "127.0.0.1", 2552) 
    
    val address = one
    
    val ref = system.actorOf(Props[GenericActor].withDeploy(Deploy(scope = RemoteScope(address))))
    println(ref)
    
    ref ! "Deploy works?"
    
}