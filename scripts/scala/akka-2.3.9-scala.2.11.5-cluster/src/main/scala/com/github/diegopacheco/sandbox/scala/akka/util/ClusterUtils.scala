package com.github.diegopacheco.sandbox.scala.akka.util

import akka.actor.ActorSystem
import akka.cluster.Cluster
import com.typesafe.config.ConfigFactory

object ClusterUtils {

    def join(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) ={
      System.setProperty("akka.remote.netty.tcp.port", port.toString)
      val config = ConfigFactory.load()
      val systemName = config.getString("akka.system")
      implicit val system = ActorSystem(systemName)
      val cluster = Cluster(system)
      val joinAddress = cluster.selfAddress
      cluster.join(joinAddress)
      (cluster,system)
    }

}
