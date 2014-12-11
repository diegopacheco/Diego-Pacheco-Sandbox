package com.github.diegopacheco.sandbox.scala.akka.routing

import akka.routing.ActorRefRoutee
import akka.routing.Router
import akka.routing.RoundRobinRoutingLogic
import akka.actor.Props
import akka.actor.Terminated
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.routing.FromConfig
import akka.actor.ActorRef
import akka.routing.RouterConfig
import com.github.diegopacheco.sandbox.scala.akka.util.Par
import scala.collection.Parallel

/**
 * akka.routing.RoundRobinRoutingLogic
   akka.routing.RandomRoutingLogic
   akka.routing.SmallestMailboxRoutingLogic
   akka.routing.BroadcastRoutingLogic
   akka.routing.ScatterGatherFirstCompletedRoutingLogic
   akka.routing.TailChoppingRoutingLogic
   akka.routing.ConsistentHashingRoutingLogic
 */
case class Work(msg:String)

class Master extends Actor {
  var router = {
    val routees = Vector.fill(5) {
       val r = context.actorOf(Props[Worker])
       context watch r
       ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }
 
  def receive = {
     case w:Work        =>  router.route(w, sender())
     case Terminated(a) =>
                           router = router.removeRoutee(a)
                           val r = context.actorOf(Props[Worker])
                           context watch r
                           router = router.addRoutee(r)
     case _ => 
         throw new RuntimeException("Wrong contract")                                                       
   }
  
}

class Worker extends Actor {
   def receive = {
       case n:Any => println(n) 
   }
}

object SimpleRouterApp extends App {
  
    val system = ActorSystem("CustomRouterActorSystemAdvanced")
    val router:ActorRef = system.actorOf( FromConfig.props(Props[Master]).withRouter(FromConfig()), name = "masterActorWorker")
    
    try{
       for( i <- (1 to 10)){
          Par.exec(){ () =>
            router ! Work("works" + i) 
          }   
       }
       router ! Work("works")
       router ! "works?"
       
    }catch{
       case e:RuntimeException => println(e.getMessage()) 
    }
  
}