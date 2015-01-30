package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor.Props
import com.github.diegopacheco.sandbox.scala.akka.util.ClusterUtils

object AdvancedClusterAppNodeB extends App{

  val (cluster,system) = ClusterUtils.join(2257)
  system.actorOf(Props[SimpleClusterListener], "SimpleClusterListener")

}