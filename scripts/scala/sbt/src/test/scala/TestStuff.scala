package com.github.diegopacheco.scala.sandbox.sbt.fun

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert._
import org.junit.Test
import org.junit.Before

object TestStuff extends AssertionsForJUnit {

  var calc = new FizzBuzz

  @Test
  def oneIsOne {
    assertEquals("1", calc.valueOf(1))
  }

}