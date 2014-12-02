package com.github.diegopacheco.sandbox.scala.akka.dispatcher

import akka.actor.ActorSystem
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.timeout._

object DispatcherPingPongMainApp extends App {
        
    val system = ActorSystem("DispatcherMainAppActorSystem")
    
    val pong = system.actorOf(Props[PongActor], name = "pong")
    val ping = system.actorOf(Props(new PingActor(pong)), name = "ping")
    
    implicit val executionContext = system.dispatchers.lookup("my-dispatcher")
    
    try{
       ping ! Start
       Thread.sleep(3000)
       ping ! Stop
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
    
}