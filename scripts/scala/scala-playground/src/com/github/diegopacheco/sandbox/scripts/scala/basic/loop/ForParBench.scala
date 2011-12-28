package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

object ForParBenchMain {
  
    object Time{
		def bench(m:String)(f: => Unit){
			val init = System.currentTimeMillis()
			f
			val end = System.currentTimeMillis()
			printf("{%s} execution in %d\n", m,(end - init))
		}
    }
  
	def main(args: Array[String]){			
		
	    import Time._  
	  
		var names:List[String]    = List("Diego","Alexandre","Jeferson","Jackson","jose","Andre")
		var surnames:List[String] = List("ego","dre","on","fck")
		
		for( i <- 1 to 1000 ){
		   names    ::= i + "A"
		   surnames ::= i + "B"
		}
		
	    printf("Names size %s \n",names.size)
	    printf("Surnames size %s \n",surnames.size)
	    
		bench("standrd"){	      
	    	val result = for {
	    		s <- surnames
		   		n <- names
		   		if n endsWith s
	    	} yield (n, s)				
	    } // {standrd} execution in 

	    bench("par"){	      
	    	val result = for {
	    		s <- surnames.par
		   		n <- names.par
		   		if n endsWith s
	    	} yield (n, s)		
	    } // {par} execution in	
	    
	    
	    // **************************************************************
	    // 
	    // Bench
	    //
	    // ***************************************************************
	    // [10K]
	    // * Names size 10006 
	    // * Surnames size 10004 
	    // * {standrd} execution in 12433
	    // * {par} execution in 28321
	    // [1K]
	    // * Names size 1006 
	    // * Surnames size 1004 
	    // * {standrd} execution in 147
	    // * {par} execution in 873
	    //
	    // ******************************************************************


	  
	}
	
}