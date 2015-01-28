package com.github.diegopacheco.sandbox.scala.akka.cluster

import akka.cluster.Cluster
import akka.actor.ActorSystem

object ClusterSystemApp extends App{

    System.setProperty("akka.remote.netty.tcp.port", "2551")
    val clusterSystem = ActorSystem("ClusterSystemAS")
    Cluster(clusterSystem)
      

}
