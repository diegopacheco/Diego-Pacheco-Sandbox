package com.github.diegopacheco.sandbox.scala.patternsmatcher

object PatternMatcher extends App {

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + " scala"
      case _ => println(o)
    }
  }
  
  println( bigger(1) )
  println( bigger(0) )
  println( bigger(-11) )
  println( bigger("rsjug") )
  println( bigger(2.5) )
  println( bigger(-1.1) )
  println( bigger(false) )
  println( bigger(() => true) )

}

