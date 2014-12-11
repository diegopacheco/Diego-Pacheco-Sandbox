package com.github.diegopacheco.sandbox.scala.akka.configs

import com.typesafe.config._
import akka.actor.ActorSystem

object AkkaConfigsPlay extends App{
    
    val conf = ConfigFactory.parseString("a.b=12")
    println(conf)
    
    val system:ActorSystem = ActorSystem.create()
    println( system.settings )
  
}