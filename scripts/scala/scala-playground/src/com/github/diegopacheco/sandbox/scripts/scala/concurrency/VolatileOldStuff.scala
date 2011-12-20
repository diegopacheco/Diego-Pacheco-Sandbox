package com.github.diegopacheco.sandbox.scripts.scala.concurrency

class PersonVolatile(@volatile var name: String) {
  def set(changedName: String) {
    name = changedName
  }
}

object VolatileOldStuff {
    def run{
    	var p = new PersonVolatile("Name")
    	println( p.name )
    }
	def main(args: Array[String]) = run
}