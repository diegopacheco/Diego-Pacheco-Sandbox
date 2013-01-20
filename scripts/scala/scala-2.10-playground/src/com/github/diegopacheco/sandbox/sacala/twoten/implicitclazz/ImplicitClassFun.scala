package com.github.diegopacheco.sandbox.sacala.twoten.implicitclazz

object ImplicitClassFun extends App {
   	
   implicit class RichInteger(n:Int) extends Ordered[Int]{
      def isMin(m:Int)  : Int = if (n <= m) n else m
      def compare(m:Int): Int = if ( n <= m ) -1 else 0
   }
   
   val i1 = 10
   val i2 = 20
   
   println( i1.isMin(i2) ) 
   
}