package com.github.diegopacheco.sandbox.scala.pkge

package object fruits {
  
  val planted = List(apple, plum, banana)               
  
  def showFruit(fruit: Fruit) {
    println(fruit.name +"s are "+ fruit.color)
  }
  
}