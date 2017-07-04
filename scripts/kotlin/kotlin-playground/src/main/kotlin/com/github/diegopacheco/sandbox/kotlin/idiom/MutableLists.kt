package com.github.diegopacheco.sandbox.kotlin.idiom

fun main(args: Array<String>) {
	
	val l = mutableListOf(1, 2, 3)
	l[0] = l[0] + 1
	l[1] = l[1] + 1
	l[2] = l[2] + 1
	
	for(i in l){
		println(i)
	}  
	
}