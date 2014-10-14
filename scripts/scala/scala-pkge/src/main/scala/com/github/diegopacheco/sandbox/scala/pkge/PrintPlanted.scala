package com.github.diegopacheco.sandbox.scala.pkge

import com.github.diegopacheco.sandbox.scala.pkge.fruits._

object PrintPlanted {
  def main(args: Array[String]) {
    for (fruit: Fruit <- fruits.planted) {
      showFruit(fruit)
    }
  }
}