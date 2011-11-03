package com.github.diegopacheco.sandbox.scala.akka.remote.actors

import akka.actor.Actor._
import akka.actor.{ActorRegistry, Actor}
import akka.remote._
import akka.actor._

object ServerManagedRemoteActorClient {
  def run = {
    val actor = Actor.remote.actorFor("hello-service", "localhost", 2552)
    
    println("[client] Sending actor message: Hello");
    val result = actor !! "Hello"
    println("[client] Actor message result: " + result);
  }
  def main(args: Array[String]) = run
}
