package com.github.diegopacheco.sandbox.scala.camel.boot

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.apache.camel.impl.DefaultCamelContext
import com.github.diegopacheco.sandbox.scala.camel.beans.Stopper

object MainApp extends App {
	
    var ctx = new ClassPathXmlApplicationContext("classpath:spring-camel-beans.xml")
    var camel:DefaultCamelContext = ctx.getBean("camel").asInstanceOf[DefaultCamelContext]
    
    ctx.getBean("stop").asInstanceOf[Stopper].setCamelCtx(camel)
    camel.start
    
    println("did stop it")
    
}