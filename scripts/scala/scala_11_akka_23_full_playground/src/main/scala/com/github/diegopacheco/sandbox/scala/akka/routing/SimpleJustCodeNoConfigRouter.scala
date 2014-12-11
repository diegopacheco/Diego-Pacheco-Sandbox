package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.RoundRobinPool

class SimpleActor2 extends Actor {
   def receive = {
       case n:Any => println(n) 
   }
}

object SimpleJustCodeNoConfigRouter extends App {
   
    val system = ActorSystem("CustomRouterActorSystem2")
    val actor:ActorRef = system.actorOf( RoundRobinPool(5).props(Props[SimpleActor2]),name = "SimpleActor2")
    
    try{
       actor ! "works"
       actor ! "works?"
       
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
}