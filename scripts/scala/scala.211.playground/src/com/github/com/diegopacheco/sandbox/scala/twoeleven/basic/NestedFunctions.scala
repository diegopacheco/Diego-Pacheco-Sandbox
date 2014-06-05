package com.github.com.diegopacheco.sandbox.scala.twoeleven.basic

object NestedFunctions extends App {
	
	object math{
	    def count(l:List[Int]):Int= {
	        def reduce(l:List[Int]):Int = {
	            return l.reduce(_+_)
	        }
	        reduce(l)
	    }
	}
	
	println( math.count( List(1,2,3,4,5,6) ) )
  
}