package com.github.diegopacheco.sandbox.scala.akka.cluster

import akka.cluster.Cluster
import akka.actor.ActorSystem

  object ClusterSystemApp extends App{

      val clusterSystem = ActorSystem("ClusterSystemAS")
      Cluster(clusterSystem)



  }
