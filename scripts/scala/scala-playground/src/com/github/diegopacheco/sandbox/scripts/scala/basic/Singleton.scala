package com.github.diegopacheco.sandbox.scripts.scala.basic

import scala.reflect._

class Person(
	@BeanProperty var name:String = "Diego Pacheco",
	@BeanProperty var email:String = "diego.pacheco.blog@gmail.com"
){
    override def toString(): String = name + " - " + email
}

object Singleton extends Person

object SingletonMainProg{
    def main(args : Array[String]) : Unit = {
        def p1 = Singleton
        def p2 = Singleton
        def p3 = Singleton
        println(p1)
        println(p2)
        println(p3)
    }
}