package com.github.diegopacheco.sandbox.scala.partial

object PartialFunctionsApp extends App {
  
  val pf:PartialFunction[Int, String] = {
     case i if i%2 == 0 => "even"
  }
  
  val tf:(Int => String) = pf orElse { case _ => "odd"}
  
  println( tf(1) == "odd" )
  println( tf(2) == "even")
  
}