package com.github.diegopacheco.sandbox.scala.akka.util

import akka.actor.{AddressFromURIString, Props, ActorSystem}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.ClusterDomainEvent
import com.github.diegopacheco.sandbox.scala.akka.cluster.advanced.SimpleClusterListener
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

    def join2(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) ={
      System.setProperty("akka.remote.netty.tcp.port", port.toString)
      val config = ConfigFactory.load()
      val systemName = config.getString("akka.system")
      implicit val system = ActorSystem(systemName)
      val cluster = Cluster(system)
      val joinAddress = AddressFromURIString("akka.tcp://ClusterSystem@127.0.0.1:2256")
      cluster.join(joinAddress)
      (cluster,system)
    }

    def joinListener(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) = {
      System.setProperty("akka.remote.netty.tcp.port", port.toString)
      val system = ActorSystem("ClusterSystem")
      val cluster = Cluster(system)

      val clusterListener = system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
      cluster.subscribe(clusterListener, classOf[ClusterDomainEvent])

      (cluster,system)
    }

    def joinListener2(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) = {
      val (cluster,system) = join(port)
      val clusterListener = system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
      cluster.subscribe(clusterListener, classOf[ClusterDomainEvent])

      (cluster,system)
    }

    def joinSimple(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) ={
      System.setProperty("akka.remote.netty.tcp.port", port.toString)
      val system = ActorSystem("ActorSystem")
      val cluster = Cluster(system)
      (cluster,system)
    }


}
