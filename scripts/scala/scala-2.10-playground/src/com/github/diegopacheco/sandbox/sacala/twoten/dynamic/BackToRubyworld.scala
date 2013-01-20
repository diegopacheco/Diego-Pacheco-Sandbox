package com.github.diegopacheco.sandbox.sacala.twoten.dynamic

import scala.language.dynamics

class Ruby extends Dynamic {   
  def applyDynamic(methodName:String)(args:Any*): Any = {
      println("Calling method: " + methodName + ", with args: " + args)
  }  
}

object BackToRubyworld extends App {
	
  val r = new Ruby
  r.foo(23)  
  r.bar()
  
}