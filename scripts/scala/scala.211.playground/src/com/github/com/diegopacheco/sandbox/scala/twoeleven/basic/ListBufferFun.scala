package com.github.com.diegopacheco.sandbox.scala.twoeleven.basic

import scala.collection.mutable.ListBuffer

object ListBufferFun extends App {

	val buffer = new ListBuffer[Int]
	buffer.append(10)
    buffer.append(20)
    buffer.append(20)

    println("Buffer: " + buffer)
    println("Count: " + buffer.toSeq.reduce(_ + _))
}
  
