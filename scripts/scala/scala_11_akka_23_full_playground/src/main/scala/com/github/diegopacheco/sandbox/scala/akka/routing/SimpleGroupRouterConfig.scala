package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.RoundRobinPool
import akka.routing.RoundRobinGroup
import akka.routing.FromConfig

class SimpleActor3 extends Actor {
   def receive = {
       case n:Any => println( "Simple: " + n) 
   }
}

class Actors extends Actor {

  context.actorOf(Props[SimpleActor3], name = "a1")
  context.actorOf(Props[SimpleActor3], name = "a2")
  context.actorOf(Props[SimpleActor3], name = "a3")
  
  def receive = {
      case n:Any => println( "Actors: " +  n)   
  }
  
}

object SimpleGroupRouterConfig extends App {
  
    val system = ActorSystem("CustomRouterActorSystem3")
    
    val paths = List("/user/workers/w1", "/user/workers/w2", "/user/workers/w3")
    val actor:ActorRef = system.actorOf( Props[Actors],name = "simpleActorGroup")
    
    try{
       actor ! "works"
       actor ! "works?"
       
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
  
}