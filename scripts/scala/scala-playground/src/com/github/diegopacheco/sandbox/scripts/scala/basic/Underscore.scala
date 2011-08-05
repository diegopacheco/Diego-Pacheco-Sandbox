package com.github.diegopacheco.sandbox.scripts.scala.basic

object Underscore {
  
  def soma = sum(_,_)
  def somaTodos = sumAll(_)
  
  def sum(a:Int,b:Int) =  sumAll(List(a,b))
  def sumAll(is:List[Int]) = is.reduceLeft(_+_) 
  
  def main(args : Array[String]) : Unit = {
	  println( soma(4,3) )
	  
	  var l = List(1,2,3,4,5)
	  println( somaTodos(l) )
  }
}
