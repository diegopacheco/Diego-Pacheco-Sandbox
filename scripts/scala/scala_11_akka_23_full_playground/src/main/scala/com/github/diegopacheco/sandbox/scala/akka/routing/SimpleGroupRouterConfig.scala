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
       case n:Any => println( "Simple: " +  self.path + " => " +  n)   
   }
}

/**
 * This actor create another actors - so we use this as a father actor
 * an this other actors on it will be child actors. If we do do this code here:
 * 
 *   val a = system.actorOf( Props[Actors],name = "Actors")
 *   
 *   This whole code does not work - since the child actors are not created.
 *   As you can see the receive loop from the Actors is not used. (never runs)
 **/
class Actors extends Actor {

  context.actorOf(Props[SimpleActor3], name = "a1")
  context.actorOf(Props[SimpleActor3], name = "a2")
  context.actorOf(Props[SimpleActor3], name = "a3")
  
  def receive = {
      case n:Any => println( "Actors: " +  self.path + " => " +  n)   
  }
  
}

object SimpleGroupRouterConfig extends App {
  
    val system = ActorSystem("CustomRouterActorSystem3")
    
    val a = system.actorOf( Props[Actors],name = "Actors")
    println("Actors Path: " + a.path)
    
    val paths = List("/user/Actors/a1", "/user/Actors/a2", "/user/Actors/a3")
    val actor:ActorRef = system.actorOf( RoundRobinGroup(paths).props(), name = "actors")
    
    try{
       actor ! "works"
       actor ! "works"
       actor ! "works"
       actor ! "works"
       actor ! "works?"
       
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
  
}