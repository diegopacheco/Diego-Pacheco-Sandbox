package com.github.diegopacheco.sandbox.scripts.scala.basic.loop

object forsample {
  def main(args: Array[String]) {
	
	for(i <- 1 to 3){
		print(i + ",")
	}
	
	for(i <- 4 until 5) { print(i + ",") }
	
  }
}