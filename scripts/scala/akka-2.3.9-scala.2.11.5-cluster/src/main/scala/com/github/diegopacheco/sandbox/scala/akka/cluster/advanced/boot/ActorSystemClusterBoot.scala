package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced.boot

import akka.actor.{ActorSystem, Props}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.ClusterDomainEvent
import akka.kernel.Bootable
import com.github.diegopacheco.sandbox.scala.akka.cluster.advanced.{SimpleClusterListener, SimpleTextMessage, DummyActorFrontend}
import com.github.diegopacheco.sandbox.scala.akka.util.{TimeUtils, ClusterUtils}

class ActorSystemClusterBoot extends Bootable {

  var cs:(Cluster,ActorSystem) = null

  def startup = {
    cs = ClusterUtils.join(2556)
    TimeUtils.wait(6)

    val actor = cs._2.actorOf(Props[DummyActorFrontend], "DummyActorRemoteCluster")
    println("Got Actor: " + actor)
    actor ! SimpleTextMessage("Ha")

    TimeUtils.wait(6)
    val clusterListener = cs._2.actorOf(Props[SimpleClusterListener], name = "clusterListener")
    cs._1.subscribe(clusterListener, classOf[ClusterDomainEvent])
  }

  def shutdown = {
    cs._2.shutdown()
  }

}
