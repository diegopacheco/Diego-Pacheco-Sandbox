package com.github.diegopacheco.sandbox.scala.akka.remote.actors

import akka.actor.Actor._
import akka.actor.{ActorRegistry, Actor}
import akka.remote._
import akka.actor._

object ServerManagedRemoteActorServer {
  def run = {
    Actor.remote.start("localhost", 2552)
    Actor.remote.register("hello-service", actorOf[HelloWorldActor])
  }
  def main(args: Array[String]) = run
}