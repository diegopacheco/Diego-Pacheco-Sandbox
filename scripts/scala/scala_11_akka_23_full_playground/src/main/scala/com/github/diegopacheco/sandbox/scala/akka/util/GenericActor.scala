package com.github.diegopacheco.sandbox.scala.akka.util

import akka.actor.Actor

class GenericActor extends Actor{
    def receive = {
       case n:Any => println("Me: " + self.path + " - got: " + n)
    }
}