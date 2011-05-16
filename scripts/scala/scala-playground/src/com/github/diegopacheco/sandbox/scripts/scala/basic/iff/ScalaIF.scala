package com.github.diegopacheco.sandbox.scripts.scala.basic.iff

object ScalaIF {
    def main(args: Array[String]): Unit = {

        val name =
            if (1 > 2)
                " nome 1 "
            else
                " nome 2 "
        
        Console.println(name)    	
    }
}
