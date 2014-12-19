package com.github.diegopacheco.scala.sandbox.akka.cluster.actors

import akka.actor.Actor

class GenericActor extends Actor {
    def receive = {
        case n:Any => println(self.path + " - received: " + n); sender() ! "OK"
    }
}
