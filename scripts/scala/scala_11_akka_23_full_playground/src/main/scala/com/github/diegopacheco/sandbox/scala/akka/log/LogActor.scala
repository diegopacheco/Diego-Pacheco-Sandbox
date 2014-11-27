package com.github.diegopacheco.sandbox.scala.akka.log

import akka.actor.Actor
import akka.event.Logging

class LogActor extends Actor {
  
  val log = Logging(context.system, this)
  
  def receive = {
    case "test"            => log.info("received test")
    case "hi"|"how"|"you"  => log.info("received hi/how/you")
    case m:Any             => log.info("receive unknown message {" + m + "}")
  }
    
}

object MainLoggingApp extends App {
  
   import akka.actor.ActorSystem
   import akka.actor.Props
  
   val system = ActorSystem("logSystem")
   
   val myActor = system.actorOf(Props[LogActor], "myactor1") 
  
   myActor ! "hi"
   myActor ! "how"
   myActor ! "are"
   myActor ! "you?"
   myActor ! "test"
   myActor ! 42
   myActor ! false
   
}
