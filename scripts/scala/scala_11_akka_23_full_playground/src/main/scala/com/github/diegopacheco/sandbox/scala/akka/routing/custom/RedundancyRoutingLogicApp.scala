package com.github.diegopacheco.sandbox.scala.akka.routing.custom

import scala.collection.immutable
import akka.routing.RoundRobinRoutingLogic
import akka.routing.RoutingLogic
import akka.routing.Routee
import akka.routing.SeveralRoutees
import akka.actor.ActorSystem
import com.github.diegopacheco.sandbox.scala.akka.util.Try
import akka.actor.ActorRef
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.GenericActor
import akka.routing.Router
import akka.routing.Pool
import akka.routing.Router
import akka.routing.Router
import akka.routing.RouterConfig
import akka.routing.CustomRouterConfig
import akka.dispatch.Dispatchers
import com.typesafe.config.Config
import akka.routing.Group
import collection.immutable.Seq

class RedundancyRoutingLogic(nbrCopies:Int) extends RoutingLogic {
  
  val roundRobin = RoundRobinRoutingLogic()
  
  def select(message:Any, routees:immutable.IndexedSeq[Routee]):Routee = {
    val targets = (1 to nbrCopies).map(_ => roundRobin.select(message, routees))
    SeveralRoutees(targets)
  }
  
}

class RedundancyGroup(override val paths: immutable.Iterable[String],nbrCopies: Int) extends Group {
 
  def this(config: Config) = this(
    paths = Seq(config.getStringList("routees.paths").asInstanceOf[String]),
    nbrCopies = config.getInt("nbr-copies"))
 
  override def createRouter(system: ActorSystem): Router =
    new Router(new RedundancyRoutingLogic(nbrCopies))
 
  override val routerDispatcher: String = Dispatchers.DefaultDispatcherId
}

object RedundancyRoutingLogicApp extends App {
    
    val system = ActorSystem("RedundancyRoutingLogicAS")
    
    
    for ( i <- 1 to 10) system.actorOf( Props[GenericActor], "a" +i)
    val paths = for (n <- 1 to 10) yield ("/user/a" + n)
    
    val actorRouter:ActorRef = system.actorOf( new RedundancyGroup(paths,5).props(), "RedundancyRoutingLogicCustomLogicActor")
    
    Try.it() { () =>
        for ( i <- 1 to 10 )  actorRouter ! "hi " + i
    } 
  
}