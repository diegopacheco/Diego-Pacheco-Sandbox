package com.github.diegopacheco.sandbox.scripts.scala.lambda

object LambdaObject extends App {
	
    case class Result(@reflect.BeanProperty var value:Object = null,@reflect.BeanProperty  var executionTime:Long = 0) {
        override def toString():String = "[value:" + value + ", executionTime: " + executionTime + "]" 
    }
  
	def benchmark( f : () => Object ):Object = {
		val init:Long = System.currentTimeMillis
		var result:Object = f()
		val end:Long = System.currentTimeMillis
		val total:Long = end - init		
		
		if (result.isInstanceOf[Result])
			result.asInstanceOf[Result].setExecutionTime(total)
		
		result
	}
    
    val r:Result = Result("Result from real method.")
    val tadaaaaa = benchmark(  () => r )
    println( tadaaaaa )
}