package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor.ActorSystem
import akka.cluster.Cluster
import com.typesafe.config.ConfigFactory

object AdvancedClusterAppNodeB extends App{

  System.setProperty("akka.remote.netty.tcp.port", "2557")
  val config = ConfigFactory.load()
  val systemName = config.getString("akka.system")
  implicit val system = ActorSystem("ClusterSystem")
  val cluster = Cluster(system)
  val joinAddress = cluster.selfAddress
  cluster.join(joinAddress)

}