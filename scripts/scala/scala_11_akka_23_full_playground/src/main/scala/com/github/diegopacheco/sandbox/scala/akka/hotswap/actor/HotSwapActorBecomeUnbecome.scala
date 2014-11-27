package com.github.diegopacheco.sandbox.scala.akka.hotswap.actor

import akka.actor.Actor

class HotSwapActor extends Actor {
  import context._
  
  def angry:Receive = {
      case "foo" => println("I am already angry?") ; sender ! "OK"
      case "bar" => become(happy)
  }
 
  def happy:Receive = {
      case "bar" => println("I am already happy :-)") ; sender ! "OK"
      case "foo" => become(angry)
  }
 
  def receive = {
      case "foo" => become(angry)
      case "bar" => become(happy)
  }
  
}

object HotSwapActorBecomeUnbecome extends App{
    
   import akka.actor.ActorSystem
   import akka.actor.Props
   import akka.actor._
  
   val system = ActorSystem("HotSwapActorSystem")
   
   val myActor = system.actorOf(Props[HotSwapActor], "myactor1") 
   
   myActor ! "foo"
   myActor ! "foo"
   myActor ! "bar"
   myActor ! "bar"
  
}