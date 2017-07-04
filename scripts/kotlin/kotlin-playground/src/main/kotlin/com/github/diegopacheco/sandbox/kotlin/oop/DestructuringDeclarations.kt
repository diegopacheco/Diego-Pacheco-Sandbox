package com.github.diegopacheco.sandbox.kotlin.oop

data class Person(val name:String, val age:Int)

fun main(args: Array<String>) {
	
	val person = Person("Diego",32)
	
	val (name, age) = person 
	println("Name $name and age $age")
	
}