package com.github.diegopacheco.sandbox.scala.akka.configs

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

object CustomConfig extends App {
  
  val config = ConfigFactory.load()
  
  val app1 = ActorSystem("MyApp1", config.getConfig("myapp1").withFallback(config))
  val app2 = ActorSystem("MyApp2", config.getConfig("myapp2").withOnlyPath("akka").withFallback(config))
  
  println(app1)
  println(app2)
  
}