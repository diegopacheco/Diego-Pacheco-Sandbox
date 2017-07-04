package com.github.diegopacheco.sandbox.kotlin.typez

fun main(args: Array<String>) {
	
	data class Person(var name:String = "")
	
	var person:Person = Person()
	
	var s = person.name
	println("1. s == ${s}")
	
	person.name = "Diego"
	s = person.name
	println("2. s == ${s}")
	
}