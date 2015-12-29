package com.github.diegopacheco.sandbox.scala.netflix.karyon

object MainRunner extends App {
    System.setProperty("java.awt.headless","true")
		System.setProperty("archaius.deployment.environment","dev")
		val s:String = classOf[KaryonJerseyServerApp].getCanonicalName()
		netflix.karyon.KaryonRunner.main(Array(s))
}