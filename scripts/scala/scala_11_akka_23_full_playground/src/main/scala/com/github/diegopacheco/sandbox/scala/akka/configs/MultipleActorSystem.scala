package com.github.diegopacheco.sandbox.scala.akka.configs

import akka.actor.ActorSystem

object MultipleActorSystem extends App {
  
  val system1:ActorSystem = ActorSystem("myapp1")
  val system2:ActorSystem = ActorSystem("myapp2")
  
  println(system1)
  println(system2)
  
}