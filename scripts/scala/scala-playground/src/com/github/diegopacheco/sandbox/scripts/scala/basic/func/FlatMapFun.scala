package com.github.diegopacheco.sandbox.scripts.scala.basic.func

object FlatMapFunMain {
     
    object Time{
		def bench(m:String)(f: => Unit){
			val init = System.currentTimeMillis()
			f
			val end = System.currentTimeMillis()
			printf("{%s} execution in %d\n", m,(end - init))
		}
    }
  
	def main(args: Array[String]) {
		
	    import Time._
	  
		val names    = List("Diego","Andre","Alexandre","Jackson","Jose","Jeferson")
		val surnames = List("on","dre")
		
		bench("flatmap"){
	    	val result = names.par.flatMap { n =>
			surnames.par 
			        .filter(s => n endsWith s)
			        .map(s => (n, s)) 
	    	}
	    	println(result)
		}	    
		
	}
}