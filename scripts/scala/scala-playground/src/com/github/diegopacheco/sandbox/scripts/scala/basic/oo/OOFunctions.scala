package com.github.diegopacheco.sandbox.scripts.scala.basic.oo

object addOne extends Function1[Int, Int] {
   def apply(m: Int):Int = m + 1
}

object addTwo extends (Int => Int) {
  def apply(m: Int): Int = m + 2
}

object OOFunctionsMain{
  def run {
	  println( addOne(1) + addTwo(1)  )
  }
  def main(args: Array[String]) = run 
}