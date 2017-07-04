package com.github.diegopacheco.sandbox.kotlin.basic

fun main(args: Array<String>) {

	val fruits:List<String> = listOf("Apple","Orange","Mango")
	
	fruits
	  .filter { it.startsWith("A") }
	  .sortedBy { it }
	  .map { it.toUpperCase() }
	  .forEach { println(it) }

}