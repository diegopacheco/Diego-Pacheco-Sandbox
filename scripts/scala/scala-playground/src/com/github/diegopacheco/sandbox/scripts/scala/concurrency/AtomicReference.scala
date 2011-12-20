package com.github.diegopacheco.sandbox.scripts.scala.concurrency

import java.util.concurrent.atomic.AtomicReference

class Person(val name: AtomicReference[String]) {
  def set(changedName: String) {
    name.set(changedName)
  }
}

object OldStuff {
    def run{
        var person = new Person(new AtomicReference("Diego"))
        person.set("Diego Pacheco")
        println( person.name )
    }
	def main(args: Array[String]) = run
}