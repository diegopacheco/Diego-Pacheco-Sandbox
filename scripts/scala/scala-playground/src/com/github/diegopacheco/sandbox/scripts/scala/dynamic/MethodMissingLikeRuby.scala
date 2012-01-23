package com.github.diegopacheco.sandbox.scripts.scala.dynamic

// -Xexperimental must be ON
// MORE: http://www.scala-lang.org/archives/downloads/distrib/files/nightly/docs/library/scala/Dynamic.html
// MORE: http://stackoverflow.com/questions/3105594/is-there-a-method-missing-in-scala
class Printer extends Dynamic{
   def applyDynamic(name:String)(args:Any) = {
       println("Method Executed: " + name + " args: " + args)
   }
}

object MethodMissingLikeRuby extends App {
	val x = new Printer
	x.beh(42)
}