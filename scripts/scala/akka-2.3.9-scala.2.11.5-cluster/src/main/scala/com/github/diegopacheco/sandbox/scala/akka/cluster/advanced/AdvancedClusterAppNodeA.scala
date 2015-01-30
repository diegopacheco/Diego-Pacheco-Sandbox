package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor._
import com.github.diegopacheco.sandbox.scala.akka.util.{TimeUtils, ClusterUtils}

object AdvancedClusterAppNodeA extends App{

  val (cluster,system) = ClusterUtils.join(2256)
  TimeUtils.wait(6)

  val actor = system.actorOf(Props[DummyActorFrontend], "DummyActorRemoteCluster")
  println("Got Actor: " + actor)
  actor ! SimpleTextMessage("Ha")

}
