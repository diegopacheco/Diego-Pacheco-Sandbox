package com.github.diegopacheco.sandbox.scripts.scala.basic.regex

object RegExFun extends App {

	val pattern = "(S|s)cala".r
	val str = "Scala is a scalable language"
	println( pattern findFirstIn str )
  
}