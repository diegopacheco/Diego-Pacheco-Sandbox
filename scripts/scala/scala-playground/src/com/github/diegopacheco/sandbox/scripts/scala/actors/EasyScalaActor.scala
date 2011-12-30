package com.github.diegopacheco.sandbox.scripts.scala.actors

object EasyScalaActor extends App {
	
	import scala.actors._
	import scala.actors.Actor._
  
	class Tom extends Actor{
		def act(){
			println("Mission Impossible ha!")
		}
	}
	
	val cruise = new Tom
	cruise.start()
  
}