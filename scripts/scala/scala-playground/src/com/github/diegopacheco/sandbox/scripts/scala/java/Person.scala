package com.github.diegopacheco.sandbox.scripts.scala.java

class Person {
	
	var name:String = ""
	var age:Int = 0
	
	def getName() = name
	def setName(s:String) = name = s
	
	def getAge() = age
	def setAge(a:Int) = age = a
	
	def show(a:java.lang.String) = println(a)
	
	override def toString() = "Name " + name + " Age " + age
	
}