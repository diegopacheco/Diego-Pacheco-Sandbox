package com.github.diegopacheco.scala.playgroung.spring.boot.fun

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.beans.factory.annotation.Autowired

@Component
class HelloWorldService {

	@Value("${name:World}")
	var name:String = ""

	def getHelloMessage():String = {
		"Hello " + this.name
	}

}

@Controller
@EnableAutoConfiguration
@ComponentScan
class SampleController extends CommandLineRunner {
	
	@Autowired
	var helloWorldService:HelloWorldService = null
    
    @RequestMapping(Array("/"))
    @ResponseBody
    def home():String = {
        "Hello World!"    
    }
    
    override def run(args:String*):Unit =  {
		println(this.helloWorldService.getHelloMessage())
	}
  
}

object SpringBootAppFun extends App {
   SpringApplication.run(classOf[SampleController])
}