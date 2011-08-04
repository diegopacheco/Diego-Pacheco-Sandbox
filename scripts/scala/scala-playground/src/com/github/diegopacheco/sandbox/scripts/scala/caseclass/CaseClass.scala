package com.github.diegopacheco.sandbox.scripts.scala.caseclass
	
case class Funcionario(name: String, surename: String, salary:Double)

object CaseClass {
  def main(args: Array[String]): Unit = {
    
	  var f = new Funcionario( name = "Diego" , 
			  				   surename = "Pacheco", 
			  				   salary = 30000)
	  println(f)
	  
	  var f2 = new Funcionario(f.name,f.surename,f.salary)
	  if (f2 == f) 
	  	println(" f == f2 | " + f2)
	  	
	  println( "HashCode: " + f.hashCode )	
  }
}
