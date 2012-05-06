package com.github.diegopacheco.sandbox.scalaz.code.for0.terrans.lists

object ScalaZConcurrentPromise extends App {
	
    import scalaz._
    import Scalaz._
	
	lazy val e = {Thread.sleep(200); "Done!"}
	
	val p = promise(e)
	
    println(  p.get  )	
  
}