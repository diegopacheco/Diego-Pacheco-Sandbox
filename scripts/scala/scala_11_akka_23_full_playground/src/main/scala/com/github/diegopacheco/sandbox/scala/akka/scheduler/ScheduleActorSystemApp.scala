package com.github.diegopacheco.sandbox.scala.akka.scheduler

import akka.actor.Actor
import akka.actor.Props
import akka.actor.ActorSystem
import scala.concurrent.duration._
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
 
object ScheduleActorSystemApp extends App {
    
    val system = ActorSystem("SchedulerAS")
    import system.dispatcher
    
    val actor = system.actorOf(Props[GenericActor],"myActorSchel")
    system.scheduler.scheduleOnce(50 milliseconds, actor, "foo")
    
    val cancellable = system.scheduler.schedule(0 milliseconds, 2 seconds){
        actor ! "Hello, we are there?"
    }
    
    Thread.sleep(6000L)
    cancellable.cancel()
  
}