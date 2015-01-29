package com.github.diegopacheco.sandbox.scala.akka.util

object Try {
  
    def it()(f:()=>Unit):Unit = {
        try{
           f() 
        }catch{
            case e:Exception => println(e.getMessage()) 
        }
    }
    
    def that()(f: => Unit):Unit = {
        try{
           f
        }catch{
            case e:Exception => println(e.getMessage()) 
        }
    }
}