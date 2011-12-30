package com.github.diegopacheco.sandbox.scripts.scala.basic.tuple

object FourWaysTuple extends App {
	println( ("Hello",3.14) )
	println( Pair("Hello",3.14) )
	println( Tuple2("Hello",3.14) )
	println( "Hello" -> 3.14 )
}