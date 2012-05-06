package com.github.diegopacheco.sandbox.scalaz.code.for0.terrans.lists

object ScalazConcurrentStuff extends App {
	
    import scalaz._
    import Scalaz._
  
	import java.util.concurrent.{Executors, Callable}
	
    val svc = Executors.newCachedThreadPool
    
    val future = svc.submit(new Callable[String] { override def call = {Thread.sleep(20); "Done!" }})
    
    println( future.get )
    
}