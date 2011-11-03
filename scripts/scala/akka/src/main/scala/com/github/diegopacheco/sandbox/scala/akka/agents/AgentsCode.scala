package com.github.diegopacheco.sandbox.scala.akka.agents

import akka.actor._
import akka.agent._
import akka.stm._
import akka.agent.Agent

import akka.actor.Actor._
import akka.actor.{ActorRegistry, Actor}
import akka.remote._
import akka.actor._

object AgentsCode {
  def transfer(from: Agent[Int], to: Agent[Int], amount: Int): Boolean = {
    atomic {
      if (from.get < amount) false
      else {
        from send (_ - amount)
        to send (_ + amount)
        true
      }
    }
  }
  def run = {   
   	val f = Agent(100)
    val t = Agent(20)
	val ok = transfer(f, t, 50)
	println(ok)
	println(f)
	println(t)
	println(f())
	println(t())
  }
  def main(args: Array[String]) = run
}
