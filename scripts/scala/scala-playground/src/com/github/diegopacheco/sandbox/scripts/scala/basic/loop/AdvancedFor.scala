package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

object Time{
	def bench(m:String)(f: => Unit){
		val init = System.currentTimeMillis()
		f
		val end = System.currentTimeMillis()
		printf("{%s} execution in %d\n", m,(end - init))
	}
}

object AdvancedFor {
	def main(args: Array[String]) {
		
	    import Time._
	  
	    val names    = List("Diego","Alexandre","Jeferson","Jackson","jose","Andre")
		var surnames = List("ego","dre","on","fck")
		
		val result = for {
	    		s <- surnames
		   		n <- names
		   		if n endsWith s
	    } yield (n, s)
	    println(result)
		
		val names2    = List("Diego","Alexandre","Jeferson","Jackson","jose","Andre")
		val surnames2 = List("ego","dre","on","fck")
		bench("standrd"){	      
	    	val result = for {
	    		s <- surnames2
		   		n <- names2
		   		if n endsWith s
	    	} yield (n, s)				
	    } // {standrd} execution in 9
	    
	    val names3    = List("Diego","Alexandre","Jeferson","Jackson","jose","Andre")
		val surnames3 = List("ego","dre","on","fck")
	    bench("par"){	      
	    	val result = for {
	    		s <- surnames3.par
		   		n <- names3.par
		   		if n endsWith s
	    	} yield (n, s)		
	    } // {par} execution in 89		
		
	  
	}
}