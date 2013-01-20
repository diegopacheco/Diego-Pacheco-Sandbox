package com.github.diegopacheco.sandbox.sacala.twoten.reflection

import scala.beans.BeanProperty

class Animal(	
  @BeanProperty  var typez:String = "Black Dog",  
  @BeanProperty  var name:String  = "1"  
){  
  
  override def toString():String = typez + " " + name
  
  def doSomeNoise():Unit = {
      println("Noise!")
  }
  
}

object ReflectionOnScalaYeah extends App {
    val animal = new Animal
  
    val universe = scala.reflect.runtime.universe
	val mirror   = universe.runtimeMirror(getClass().getClassLoader())	
	val im       =  mirror.reflect(animal)
	
	println(s"Animal: $animal")
	println("Clazz : " + im.instance)
	
	val methodsymbol = universe.typeOf[Animal].declaration(universe.newTermName("doSomeNoise")).asMethod
    val method       = im.reflectMethod(methodsymbol)
    println( method() )
    
}