package com.github.diegopacheco.sandbox.scripts.scala.pattern.matching

object TyperMatcherOnTuples extends App {
	
	def pointRef(i:Any) = i match {
		case (x,y) => printf("Point X %s Y %s \n",x,y)
		case (x) => printf("Point X %s \n",x)		
	}
	
	pointRef( (1,2) )
	pointRef( (3) )
	pointRef( false )
	
}