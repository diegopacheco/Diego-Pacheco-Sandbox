package com.github.diegopacheco.sandbox.scala.akka.actor.serialization

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.serialization._


object AkkaSerializationSystemApp extends App {
  
    val system = ActorSystem("example")
    
    val serialization = SerializationExtension(system)
    println(serialization)
    
    val msg = "woohoo"
    println(msg)
    
    val serializer = serialization.findSerializerFor(msg)
    println(serializer)
    
    val bytes = serializer.toBinary(msg)
    println(bytes)
    
    val back = serializer.fromBinary(bytes, manifest = None)
    println(back)
    
}