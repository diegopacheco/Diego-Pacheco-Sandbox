package com.github.diegopacheco.sandbox.kotlin.oop

fun main(args: Array<String>) {
	
	class Empty
	println(Empty())
	
	class Person constructor(firstName: String) {
		init{
			println("Init working ... ${firstName}")
		}
	}	
	Person("Diego")
	
	class Person2 {
		 constructor(firstName:String) {
			println("Init working ... ${firstName}") 
		 }
	}
	Person2("Diego")
	
}