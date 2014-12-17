package com.github.diegopacheco.sandbox.scala.akka.circuitbreaker

import scala.concurrent.duration._
import akka.pattern.CircuitBreaker
import akka.pattern.pipe
import akka.actor.Actor
import akka.actor.ActorLogging
import scala.concurrent.Future
import akka.event.Logging
import akka.actor.ActorSystem
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import com.github.diegopacheco.sandbox.scala.akka.util.Ask

class DangerousActor extends Actor with ActorLogging {
  
  import context.dispatcher
 
  val breaker =
    new CircuitBreaker(context.system.scheduler,
      maxFailures = 5,
      callTimeout = 10.seconds,
      resetTimeout = 1.minute).onOpen(notifyMeOnOpen())
 
  def notifyMeOnOpen():Unit =
     log.info("My CircuitBreaker is now open, and will not close for one minute")
    
  def receive = {
      case "fail"      => breaker.withCircuitBreaker(Future(failMethod)) pipeTo sender()
      case "timeout"   => breaker.withCircuitBreaker(Future(timeoutMethod)) pipeTo sender()
      case "block"     => sender() ! breaker.withSyncCircuitBreaker(okMethod(true))
      case n:Any       => breaker.withCircuitBreaker(Future(okMethod(n))) pipeTo sender()
  }  
  
  def okMethod(n:Any) = {
      println("Received: " + n + " - OK")
  }
  
  def failMethod = {
     println("Received: FAIL ") 
     throw new RuntimeException("fail")
  }
  
  def timeoutMethod = {
    Thread.sleep(12000L) 
    println("timeout") 
  }
  
}

object CircuitBreakerApp extends App {
    
    val system = ActorSystem("CircuitBreakerAS")
    val actor = system.actorOf(Props[DangerousActor],"dangerousActor")
    
    Try.that(){
        actor ! "ok"
        actor ! "ok"
        
        actor ! "block"
        
        Ask.get(actor,"timeout")
        Ask.get(actor,"fail")
        
        actor ! "ok"
    }
    
}