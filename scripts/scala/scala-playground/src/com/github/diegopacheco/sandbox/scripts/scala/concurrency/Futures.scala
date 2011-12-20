package com.github.diegopacheco.sandbox.scripts.scala.concurrency

import java.util.concurrent.FutureTask
import java.util.concurrent.Callable
import java.util.concurrent.{Executors,ExecutorService}

object Futures {
    def run{
        val future = new FutureTask[Unit](new Callable[Unit](){
        	def call():Unit = println("Future Result")
        })
        
        val pool:ExecutorService = Executors.newFixedThreadPool(2)
        pool.execute(future)
    }
	def main(args: Array[String]) = run
}