package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.FromConfig

class SimpleActor1 extends Actor {
   def receive = {
       case n:Any => println(n) 
   }
}

object UltraSimpleConfigRouter extends App {
  
    val system = ActorSystem("CustomRouterActorSystem")
    val actor:ActorRef = system.actorOf( FromConfig.props(Props[SimpleActor1]).withRouter(FromConfig()), name = "simpleActor1")
    
    try{
       actor ! "works"
       actor ! "works"
       actor ! "works"
       actor ! "works?"
       
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
  
}