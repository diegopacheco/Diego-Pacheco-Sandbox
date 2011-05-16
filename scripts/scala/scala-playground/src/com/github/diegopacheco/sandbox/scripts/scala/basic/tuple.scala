package com.github.diegopacheco.sandbox.scripts.scala.basic

object tuple {
	
	def wow = {
		("Diego", "Pacheco", "Scala")
	}
	
	def main(args : Array[String]) : Unit = {
	    val (name, last, lang) = wow
	    printf("Name is %s\nLast Name is %s\nLanguage is: %s", name, last, lang)
	}
}
