package com.github.diegopacheco.sandbox.scripts.scala.basic

object CurryingMain {
  def main(args: Array[String]): Unit = {	  
	  val numbersAscList = 1::2::3::4::5::Nil
	  println ( numbersAscList )   // List(1, 2, 3, 4, 5)
  }
}