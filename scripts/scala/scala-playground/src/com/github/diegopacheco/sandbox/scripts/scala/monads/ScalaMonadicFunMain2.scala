package com.github.diegopacheco.sandbox.scripts.scala.monads

object ScalaMonadicFunMain2 {
	def main(args: Array[String]) {
		
	    sealed trait Option[+A] {
		   def bind[B](f: A => Option[B]): Option[B]
	    } 
	    case class Some[+A](value: A) extends Option[A] {
		   def bind[B](f: A => Option[B]) = f(value)
	    } 
	    case object None extends Option[Nothing] {
		    def bind[B](f: Nothing => Option[B]) = None
	    }
	  
		def firstName(id:Int):Option[String] = Some("Diego")
		def lastName(id:Int):Option[String]  = Some("Pacheco")
	  
		def fullName(id: Int): Option[String] = {
			firstName(id) bind { fname =>
				lastName(id) bind { lname =>
					Some(fname + " " + lname)
				}
			}
		}
		
		println( fullName(1) )		
	}
}