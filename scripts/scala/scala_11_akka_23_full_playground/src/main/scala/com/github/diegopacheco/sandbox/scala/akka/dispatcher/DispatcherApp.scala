package com.github.diegopacheco.sandbox.scala.akka.dispatcher

package com.github.diegopacheco.sandbox.scala.akka.timeout

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala

/**
 *  Dispatchers:
 *      - Dispatcher -> shared pool - Event based: ThreadPool or ForkJoin
 *      - PinnedDispatcher -> didicated per actor, 1 threadpool per actor
 *      - BalancingDispatcher -> shared and re-distributed work: busy or idle
 *      - CallingThreadDispatcher -> current thread - dont create new threads
 *  
 */

trait Message { var content:String="" }
case class Start() extends Message
case class Stop() extends Message
case class Ping() extends Message
case class Pong() extends Message

class PingActor(val pong:ActorRef) extends Actor {
   def receive = { 
           case Start => println("ping") ; pong ! Ping 
           case Pong => println("ping") ; sender ! Ping
           case Stop => 
                 println("STOP") 
                 sender ! Stop
                 context.system.stop(self) 
   }      
}

class PongActor extends Actor {
   def receive = { 
       case Ping => println("pong") ; sender ! Pong
       case Stop => 
          val ref:ActorRef = self     
          context.system.stop(ref) 
   }      
}
