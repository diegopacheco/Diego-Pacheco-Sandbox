package com.github.diegopacheco.sandbox.scripts.scala.basic.scope

package object scalapkg {   
   
    def helloworld():Unit = Console.println("Hello World")
    
    object Hey{
       def ho():Unit = println("Hey Ho!")
    }
  
}

// check out WhereIsThisPackageScopeFunOne.scala
