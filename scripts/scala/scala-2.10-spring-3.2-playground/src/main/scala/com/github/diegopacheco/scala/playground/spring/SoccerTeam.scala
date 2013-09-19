package com.github.diegopacheco.scala.playground.spring

import scala.beans.BeanProperty

class SoccerTeam(@BeanProperty var address:String = "") extends Team {
	def this() = this(address = "")
	override def toString():String = {
	    val s:String =  s" name: ${name} Adress: ${this.address} "
	    return s
	}
}