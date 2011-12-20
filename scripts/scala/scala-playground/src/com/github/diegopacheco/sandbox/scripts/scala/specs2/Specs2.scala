package com.github.diegopacheco.sandbox.scripts.scala.specs2

import org.specs2.mutable._
import org.specs2.runner.ClassRunner

class ArithmeticSpec extends Specification {  
   "The Aritmethic" should {
      "add two numbers" in {
    	  1 + 1 mustEqual 2
      }
      "add three numbers" in {
    	  1 + 1 + 1 mustEqual 3
      }
    }
}

object MainSpec2RunA{
   def main(args: Array[String]) {
	   new org.specs2.runner.ClassRunner().apply(new ArithmeticSpec)
   }
}