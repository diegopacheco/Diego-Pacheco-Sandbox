package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor._
import akka.cluster.ClusterEvent.ClusterDomainEvent
import com.github.diegopacheco.sandbox.scala.akka.util.{TimeUtils, ClusterUtils}

object AdvancedClusterAppNodeA {

  def main(args:Array[String]):Unit = {
      val (cluster,system) = ClusterUtils.join(args(0).toInt)
      TimeUtils.wait(6)

      val actor = system.actorOf(Props[DummyActorFrontend], "DummyActorRemoteCluster")
      println("Got Actor: " + actor)
      actor ! SimpleTextMessage("Ha")

      TimeUtils.wait(6)
      val clusterListener = system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
      cluster.subscribe(clusterListener, classOf[ClusterDomainEvent])

  }

}
