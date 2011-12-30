package com.github.diegopacheco.sandbox.scripts.scala.actors

object ActorFun extends App {
	
	import scala.actors._
	import scala.actors.Actor._
	
	val deniro = actor {
		loop{
			receive{
				case s:String => println("Got String: " + s)
				case i:Int => println("Got Int: " + i)
				case _ => println("Have no idea whats is going on...")
			}
		}
	}
	
	deniro ! "Roberto"
	deniro ! 40
	deniro !! false
	
	
}