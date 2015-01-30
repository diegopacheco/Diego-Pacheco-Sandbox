package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced

import akka.actor.{ActorLogging, ActorSystem, Deploy, Props}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.{CurrentClusterState, MemberUp}
import akka.cluster.routing.{ClusterRouterPoolSettings, SystemLoadAverageMetricsSelector, AdaptiveLoadBalancingPool, ClusterRouterPool}
import akka.remote.RemoteScope
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

object AdvancedClusterAppNodeA extends App{

  System.setProperty("akka.remote.netty.tcp.port", "2556")
  val config = ConfigFactory.load()
  val systemName = config.getString("akka.system")
  implicit val system = ActorSystem(systemName)
  val cluster = Cluster(system)
  val joinAddress = cluster.selfAddress
  cluster.join(joinAddress)

  Thread.sleep(6.seconds.toMillis)

  import akka.actor.ActorDSL._
  val client = actor(new Act with ActorLogging {
    become {
      case ccs:CurrentClusterState  =>
          val act = system.actorOf(Props[DummyActor].withDeploy(
                                   Deploy(scope = RemoteScope(ccs.getLeader))).
                                   withRouter( ClusterRouterPool( AdaptiveLoadBalancingPool(
                                       SystemLoadAverageMetricsSelector), ClusterRouterPoolSettings(
                                                totalInstances = 10, maxInstancesPerNode = 3,
                                                allowLocalRoutees = false, useRole = Some("frontend")))),
                                   name = "DummyActorRemoteCluster")
          println("Deployed: " + act.path)
      case o:Any =>
          println("Got Event: " + o)
    }
  })
  cluster.subscribe(client, classOf[MemberUp])

  Thread.sleep(6.seconds.toMillis)

  val rcActor = system.actorSelection("akka.tcp://ClusterSystem@127.0.0.1:2556/user/DummyActorRemoteCluster")
  println("Got Actor: " + rcActor.pathString)
  rcActor ! "Ha"

}
