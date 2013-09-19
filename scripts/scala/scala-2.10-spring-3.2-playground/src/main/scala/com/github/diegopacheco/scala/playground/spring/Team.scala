package com.github.diegopacheco.scala.playground.spring

import scala.beans.BeanProperty

abstract class Team(@BeanProperty var name:String = "") {
	def this() = this("")
}