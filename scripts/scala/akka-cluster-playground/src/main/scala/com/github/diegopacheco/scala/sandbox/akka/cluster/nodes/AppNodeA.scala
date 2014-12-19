package com.github.diegopacheco.scala.sandbox.akka.cluster.nodes

import akka.actor.ActorSystem
import akka.cluster.Cluster

object AppNodeA extends App{

  System.setProperty("akka.remote.netty.tcp.port", "2551")
  val system = ActorSystem("ClusterSystem")
  Cluster.apply(system)

}
