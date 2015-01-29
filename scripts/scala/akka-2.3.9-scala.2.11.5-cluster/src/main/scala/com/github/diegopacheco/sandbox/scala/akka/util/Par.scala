package com.github.diegopacheco.sandbox.scala.akka.util

object Par {
  
    def exec()(f:()=>Unit):Unit = {
        Thread.sleep(500)
        new Thread( new Runnable(){ def run = { f() } } ).start
    }
  
}