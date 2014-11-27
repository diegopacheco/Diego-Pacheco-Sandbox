package com.github.diegopacheco.sandbox.scala.akka.lifecycle

import akka.actor.Actor
import akka.event.Logging

class LifeCycleActor extends Actor {
  
    val log = Logging(context.system, this)
    def receive = {
      case m:Any => log.info("receive unknown message {" + m + "}")
    }
    
    override def preStart(): Unit = {
       log.info("Pre Start")
    }
 
    override def postStop(): Unit = {
      log.info("Post Stop")
    }
    
    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      log.info("Pre Restart")
    }
    
    override def postRestart(reason: Throwable): Unit = {
      log.info("Post Restart")
    }
  
}

object MainLoggingApp extends App {
  
   import akka.actor.ActorSystem
   import akka.actor.Props
   import akka.actor._
  
   val system = ActorSystem("LifeActorSystem")
   
   val myActor = system.actorOf(Props[LifeCycleActor], "myactor2") 
  
   myActor ! "hi"
   
   Thread.sleep(3000L)
   system.stop(myActor)
   Thread.sleep(3000L)
   
   myActor ! "hi" 
   myActor ! PoisonPill 
   
   system.shutdown()
   
   
}