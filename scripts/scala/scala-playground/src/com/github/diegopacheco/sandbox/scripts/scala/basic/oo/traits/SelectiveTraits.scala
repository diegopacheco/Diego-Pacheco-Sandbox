package com.github.diegopacheco.sandbox.scripts.scala.basic.oo.traits

//
// Traits Mixims compositions with 'with' - Kick Ass !!!
//
object SelectiveTraits extends App {
	
	trait Printer{
	    def print(m:String):Unit = println(m)
	}
	
	trait UppercasePrinter extends Printer{
	    override def print(m:String):Unit = super.print(m.toUpperCase())
	}
	
	trait StarsPrinter extends Printer{
	    override def print(m:String):Unit = super.print("* " + m + " *")
	}
	
	val printer = new Printer with UppercasePrinter with StarsPrinter
	printer.print("scala traits rocks")
  
}