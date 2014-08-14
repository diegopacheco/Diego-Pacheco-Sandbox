package com.github.diegopacheco.scala.sandbox.sbt.fun.tests

import org.scalatest.junit.JUnitSuite
import junit.framework.Assert._
import org.junit.Test

import package com.github.diegopacheco.scala.sandbox.sbt.fun.FizzBuzz

class TestStuff extends JUnitSuite {

  val calc = new FizzBuzz

  @Test
  def oneIsOne {
    assertEquals("1", calc valueOf 1)
  }

}