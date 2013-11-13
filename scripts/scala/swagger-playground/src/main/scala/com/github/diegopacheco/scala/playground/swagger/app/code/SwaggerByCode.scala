package com.github.diegopacheco.scala.playground.swagger.app.code

import scala.beans.BeanProperty


class SwaggerByCode(@BeanProperty var apiVersion:String="1.0",
					@BeanProperty var swaggerVersion:String="1.3.0",
					@BeanProperty var basePath:String="",
					@BeanProperty var resourcePath:String="") {
	
	def expose():Unit = {
			
	}
  
}