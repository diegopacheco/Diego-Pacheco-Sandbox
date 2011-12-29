package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits

object OptionsToNotNullSucks extends App {
	
	val l1:Option[String] = Some("Scala")
	val l2:Option[String] = None
	
	println( l1.getOrElse("-") )
	println( l2.getOrElse("-") )
  
}