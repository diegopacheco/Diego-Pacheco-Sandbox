package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.cluster.Cluster
import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.Ask
import akka.routing.FromConfig
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Address
    

object AdvancedClusterAppNodeA extends App{


  System.setProperty("akka.remote.netty.tcp.port", "2556")
  System.setProperty("akka.cluster.seed-nodes.0","akka.tcp://ClusterSystem@127.0.0.1:2556")
  
  val clusterSystem = ActorSystem("ClusterSystem", ConfigFactory.load(AdvancedClusterAppConfig.conf))
  Cluster.get(clusterSystem).join(Address("akka.tcp","ClusterSystem", "127.0.0.1", 2556))
  
  val actorStats = clusterSystem.actorOf(FromConfig.props(Props(classOf[StatsWorker]).withRouter(FromConfig())),"statsRouter")
  println("Actor Path: " + actorStats.path)
  val result = Ask.get[Int](actorStats, "Hello World")
  println("Scala Akka Cluster: StatsWorker Actor => " + result)
  
  //val actor = clusterSystem.actorOf(FromConfig.props(Props(classOf[FactorialFrontend], 3, true).withRouter(FromConfig())),"factorialFrontendRouter")
  //println("Actor FrontEnd Path: " + actor.path)
  //val factorial = Ask.get[BigInt](actor, 2)
  //println("Scala Akka Cluster: FrontEnd Actor - Factorial 6 => " + factorial)

}
