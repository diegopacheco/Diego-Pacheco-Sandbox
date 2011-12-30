package com.github.diegopacheco.sandbox.scripts.scala.pattern.matching

import scala.reflect.BeanProperty

object TyperMatcherCaseClasses extends App {

   trait DayOfWeek{
	   @BeanProperty var whatTodo:String
   }
   case class Monday(@BeanProperty   var whatTodo:String) extends DayOfWeek
   case class Saturday(@BeanProperty var whatTodo:String) extends DayOfWeek
   case class Sunday(@BeanProperty   var whatTodo:String) extends DayOfWeek
   
   class JobChecker(){
	   def check(dow:DayOfWeek) = dow match{
	       case Monday("Soccer") 	   				=> println("NO")
	       case Saturday(s) if s.contains("Party")  => println("OK")
	       case Monday(_) 		 	   				=> println("OK")
	       case _ 									=> println("? = NO") 
	   }
   }
   
   new JobChecker().check(new Monday("Soccer"))
   new JobChecker().check(new Saturday("Hard Party"))
   new JobChecker().check(new Monday("whatever"))
   
}