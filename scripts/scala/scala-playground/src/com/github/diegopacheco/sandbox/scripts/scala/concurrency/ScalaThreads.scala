package com.github.diegopacheco.sandbox.scripts.scala.concurrency

object ScalaThreads {
    def run{
        val hello = new Thread(new Runnable {
        	def run() = println("hello world")        	
        }).start()
    }
	def main(args: Array[String]) = run
}