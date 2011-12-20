package com.github.diegopacheco.sandbox.scripts.scala.concurrency

class PersonSync(var name: String) {
  def set(changedName: String) {
    this.synchronized {
      name = changedName
    }
  }
  override def toString = name
}

object ScalaSyncOldStuff {
    def run{
    	val p = new PersonSync("d")
    	p.set("Diego Pacheco")
    	println(p)
    }
	def main(args: Array[String]) = run
}