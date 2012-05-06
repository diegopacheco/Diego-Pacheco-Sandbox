package com.github.diegopacheco.sandbox.scalaz.code.for0.terrans.lists

import scalaz._
import Scalaz._

//
// A Digit data type (0-9)
//
object ScalaZDigitApp extends App {

  val d1 = Digit
  
  println( d1 )
  println( d1._1 )
  println( d1.value.toString )
  println( d1.toString.value.toString )
  
}