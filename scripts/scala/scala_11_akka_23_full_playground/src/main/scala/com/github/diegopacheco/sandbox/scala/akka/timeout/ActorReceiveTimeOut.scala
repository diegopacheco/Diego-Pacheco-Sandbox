package com.github.diegopacheco.sandbox.scala.akka.timeout

import akka.actor.Actor
import akka.actor.ReceiveTimeout
import scala.concurrent.duration._
import akka.actor.ActorSystem
import akka.actor.Props

class ActorReceiveTimeOut extends Actor {
   
  // sets initial delay
  //context.setReceiveTimeout(1 milliseconds)
      
   def receive = { 
           case "works" => println("OK") 
           case "Hello" => context.setReceiveTimeout(1000 milliseconds); 
           case ReceiveTimeout => throw new RuntimeException("Receive timed out")
   }      
  
}

object ActorReceiveTimeOutMainApp extends App {
    
    val system = ActorSystem("ActorReceiveTimeOutActorSystem")
    val actor  = system.actorOf(Props[ActorReceiveTimeOut],"actor01")
    
    try{
       actor ! "works"
       actor ! "Hello"
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
    
}
