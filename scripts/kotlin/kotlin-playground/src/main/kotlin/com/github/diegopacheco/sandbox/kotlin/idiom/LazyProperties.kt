package com.github.diegopacheco.sandbox.kotlin.idiom

import java.util.UUID

fun main(args: Array<String>) {
	
	val load:String by lazy {
		println("Lazy, working now... ")
		UUID.randomUUID().toString()
	}
	
	println("Nothing in this hand")
	println("Nothing in this hand")
	println(load)
	
}
