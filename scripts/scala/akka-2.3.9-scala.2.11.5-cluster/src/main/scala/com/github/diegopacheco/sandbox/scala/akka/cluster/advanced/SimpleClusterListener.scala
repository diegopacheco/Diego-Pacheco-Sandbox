package com.github.diegopacheco.sandbox.scala.akka.cluster.advanced;

import akka.actor.{Actor, ActorLogging}
import akka.cluster.ClusterEvent._

class SimpleClusterListener extends Actor with ActorLogging {
  def receive = {
    case state:CurrentClusterState  			     =>  log.info("ListenerActor: Current members: {}", state.members.mkString(", "))
    case MemberUp(member)                      =>  log.info("ListenerActor: Member is Up: {}", member.address)
    case UnreachableMember(member)             =>  log.info("ListenerActor: Member detected as unreachable: {}", member)
    case MemberRemoved(member, previousStatus) =>  log.info("ListenerActor: Member is Removed: {} after {}", member.address, previousStatus)
    case _: MemberEvent                        => // ignore
  }
}