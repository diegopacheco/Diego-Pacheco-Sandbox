package com.github.diegopacheco.sandbox.scripts.scala.basic

object Underscore {
  
  def sum(a:Int,b:Int) =  sumAll(List(a,b))
  def sumAll(is:List[Int]) = is.reduceLeft(_+_)
  
  def main(args : Array[String]) : Unit = {
	  println( sum(4,3) )
  }
}
