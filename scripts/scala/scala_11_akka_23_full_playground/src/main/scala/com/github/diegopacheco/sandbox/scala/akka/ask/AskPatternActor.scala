package com.github.diegopacheco.sandbox.scala.akka.ask

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.ExecutionContext
import scala.concurrent.Await
import scala.concurrent.Future

class AskPatternActor extends Actor{
    
    def receive = {
        case o:Any => sender ! (o + " -  OK") 
    }

}

object AskPatternActorMainapp extends App {
    
    val system = ActorSystem("AskPatternActorSystem")
    val actor  = system.actorOf(Props[AskPatternActor],"askpa1")
    
    import scala.concurrent.duration._
    import akka.util.Timeout
    import akka.pattern.ask
    implicit val timeout = Timeout(5 seconds)
    
    val future = actor ? "Hey"
    val result = Await.result(future, timeout.duration).asInstanceOf[String]
    println(result)
  
    val future2: Future[String] = ask(actor, "Hey 2").mapTo[String]
    println(Await.result(future2, timeout.duration).asInstanceOf[String])
    
}