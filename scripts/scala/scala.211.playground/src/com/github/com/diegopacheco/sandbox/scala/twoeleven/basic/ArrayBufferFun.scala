package com.github.com.diegopacheco.sandbox.scala.twoeleven.basic

import scala.collection.mutable.ArrayBuffer

object ArrayBufferFun extends App {
	
	val buffer = new ArrayBuffer[Int]
    buffer.append(10)
    buffer.append(20)
    buffer.append(20)
    
    println("Buffer: " + buffer)
    println("Count: " + buffer.toSeq.reduce(_+_) )
}