package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {
	
	var a = 1
	val s1 = "a is $a" 
	
	a = 2
	val s2 = "${s1.replace("is", "was")}, but now is $a"
	
	println(a)
	println(s1)
	println(a)
	println(s2)
	
}