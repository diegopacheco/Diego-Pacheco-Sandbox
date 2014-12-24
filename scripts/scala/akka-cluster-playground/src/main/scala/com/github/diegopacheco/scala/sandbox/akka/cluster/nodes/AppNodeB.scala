package com.github.diegopacheco.scala.sandbox.akka.cluster.nodes

import akka.actor.{Props, ActorSystem}
import akka.cluster.Cluster
import akka.routing.FromConfig
import com.github.diegopacheco.scala.sandbox.akka.cluster.actors.FactorialFrontend

object AppNodeB extends App{

  System.setProperty("akka.remote.netty.tcp.port", "2557")
  val system = ActorSystem("ClusterSystem")
  Cluster.apply(system)
  //println(system.settings)

  val frontendActor = system.actorOf(FromConfig.props(Props(classOf[FactorialFrontend],2,true).withRouter(FromConfig())),"factorialFrontendRouter")
  println("Here we go : " + frontendActor)

}
