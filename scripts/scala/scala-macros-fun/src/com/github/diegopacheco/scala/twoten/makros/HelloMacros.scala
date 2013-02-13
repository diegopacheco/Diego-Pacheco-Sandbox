package com.github.diegopacheco.scala.twoten.makros

import language.experimental.macros
import scala.reflect.macros.Context

object HelloMakros {
  
  def hello(): Unit = macro hello_impl
  
  def hello_impl(c: Context)(): c.Expr[Unit] = {
    import c.universe._
    reify { println("Hello World!") }
  }   
  
}

