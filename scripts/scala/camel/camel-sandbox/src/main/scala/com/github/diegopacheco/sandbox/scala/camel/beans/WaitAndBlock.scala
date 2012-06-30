package com.github.diegopacheco.sandbox.scala.camel.beans

class WaitAndBlock {
	
    def process():Unit = Thread.sleep(5000L)
    
}