package com.github.diegopacheco.scala.akka.cluster.simple

import akka.actor._
import akka.cluster.Cluster
import akka.cluster.ClusterEvent._

object SimpleClusterApp {
	def main(args: Array[String]): Unit = {
		
		if (args.nonEmpty) System.setProperty("akka.remote.netty.tcp.port", args(0))

		val system = ActorSystem("ClusterSystem")
		val clusterListener = system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
		
		Cluster(system).subscribe(clusterListener, classOf[ClusterDomainEvent])
	}
}

class SimpleClusterListener extends Actor with ActorLogging {
	def receive = {
		case state: CurrentClusterState  			=> 	log.info("Current members: {}", state.members.mkString(", "))
		case MemberUp(member)            			=>	log.info("Member is Up: {}", member.address)
		case UnreachableMember(member)   			=> 	log.info("Member detected as unreachable: {}", member)
		case MemberRemoved(member, previousStatus)  =>	log.info("Member is Removed: {} after {}",member.address, previousStatus)			
		case _: ClusterDomainEvent  				=> // ignore
	}
}

