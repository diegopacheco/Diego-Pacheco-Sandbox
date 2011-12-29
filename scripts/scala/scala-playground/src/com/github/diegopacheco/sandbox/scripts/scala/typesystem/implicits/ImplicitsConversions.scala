package com.github.diegopacheco.sandbox.scripts.scala.typesystem.implicits

import java.util.Date
import java.util.Calendar

object ImplicitsConversions extends App {
	
	class DateHelper(n:Int){
		def days(when:String):Date = {
			var date =Calendar.getInstance()
			when match {
			     case "ago" => date.add(Calendar.DAY_OF_MONTH,-n)
			     case "from_now" => date.add(Calendar.DAY_OF_MONTH,n)
			     case _ => date
			}
			date.getTime()
		}
	}
	
	object DateHelper{
		val ago = "ago"
        val from_now = "from_now"
        implicit def convertInt2DateHelper(n:Int) = new DateHelper(n)  
	}
	
	import DateHelper._
	
	val past = 2 days ago
	val meeting = 3 days from_now
	
	println(past)
	println(meeting)
	
}