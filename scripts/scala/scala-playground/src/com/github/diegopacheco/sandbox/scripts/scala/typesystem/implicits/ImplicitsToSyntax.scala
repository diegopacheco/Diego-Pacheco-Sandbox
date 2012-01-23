package com.github.diegopacheco.sandbox.scripts.scala.typesystem.implicits

// Source: http://stackoverflow.com/questions/1538598/how-in-scala-to-find-unique-items-in-list
object ListExtra{
	def unique[A](ls: List[A]):List[A] = {
	    def loop(set: Set[A], ls: List[A]): List[A] = ls match {
	  		case hd :: tail if set contains hd => loop(set, tail)
	  		case hd :: tail => hd :: loop(set + hd, tail)
	  		case Nil => Nil
	    }	
	    loop(Set(), ls)
   }	
}

object ListExtraImplicits{
	implicit def listToSyntax[A](ls: List[A]) = new {
		def uniqueList = ListExtra.unique(ls)
	}
}

object ImplicitsToSyntaxMain extends App {
	import ListExtraImplicits._
	println( List(1, 1, 2, 3, 4, 5, 4).uniqueList  )		
}