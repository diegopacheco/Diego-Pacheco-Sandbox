package com.github.diegopacheco.sandbox.scala.akka.util

import akka.actor.{ActorSystem, AddressFromURIString, Props}
import akka.cluster.Cluster
import com.github.diegopacheco.sandbox.scala.akka.cluster.advanced.SimpleTextMessage
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

    var csHolder:(akka.cluster.Cluster,akka.actor.ActorSystem) = null

    def joinSimple(port:Int): (akka.cluster.Cluster,akka.actor.ActorSystem) ={
      System.setProperty("akka.remote.netty.tcp.port", port.toString)
      val system = ActorSystem("ActorSystem")
      val cluster = Cluster(system)
      (cluster,system)
    }

    def joinBackground(port:Int):Unit = {
        Par.background(){ () =>
            csHolder = joinSimple(port)
        }
    }

    def sendMessage(msg:String,atr:Class[_<:akka.actor.Actor]):Unit = {
        val a = csHolder._2.actorOf(Props(atr), "DummyActorRemoteCluster")
        a ! SimpleTextMessage(msg)
    }

}
