package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.cluster.Cluster
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Address

object AdvancedClusterAppNodeB extends App{
    
  //System.setProperty("akka.remote.netty.tcp.port", "2557")
  //System.setProperty("akka.cluster.seed-nodes.1","akka.tcp://ClusterSystem@127.0.0.1:2557")
  
  val clusterSystem = ActorSystem("ClusterSystem", ConfigFactory.load(AdvancedClusterAppConfig.conf))
  Cluster.get(clusterSystem).join(Address("akka.tcp","ClusterSystem", "127.0.0.1", 2557))
  //Cluster(clusterSystem)
  
}