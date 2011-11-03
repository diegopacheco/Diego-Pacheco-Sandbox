package com.github.diegopacheco.sandbox.scala.akka.stm

import akka.stm._

class stmFun {
  def fun():Unit = {
    val ref = Ref(0)

    def counter = atomic {
      ref alter (_ + 1)
    }
    
    println(ref)
    counter
    println(ref)
    
    println(ref)
    counter
    println(ref)
  }
}

object stmRules {
  def run = {
    new stmFun().fun
  }
  def main(args: Array[String]) = run
}