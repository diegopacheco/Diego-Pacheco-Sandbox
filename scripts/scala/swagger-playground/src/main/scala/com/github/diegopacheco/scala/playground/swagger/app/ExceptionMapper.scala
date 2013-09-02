package com.github.diegopacheco.scala.playground.swagger.app

import javax.ws.rs._
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import javax.ws.rs.ext._
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import scala.beans.BeanProperty

@XmlRootElement
class ApiResponse(
  @BeanProperty var ERROR:Int   = 1,
  @BeanProperty var WARNING:Int = 2,
  @BeanProperty var INFO:Int 	  = 3,
  @BeanProperty var OK:Int = 4,
  @BeanProperty var TOO_BUSY:Int = 5,
  @BeanProperty var code:Int  = 0,
  @BeanProperty var typez:Int = 0,
  @BeanProperty var message:String = ""    
) {
  
  def this(codez:Int, message:String ) = {    
    this(message = message)
  }
}

@Provider
class SwaggerScalaExceptionMapper extends ExceptionMapper[Exception] {
  
  def toResponse(ex:Exception):Response = {
    
    if (ex.isInstanceOf[WebApplicationException]) {
	      var e:WebApplicationException = ex.asInstanceOf[WebApplicationException]
	      return Response          
	    	  .status(e.getResponse().getStatus())
	          .entity(new ApiResponse(code = e.getResponse().getStatus(), message = ex.getMessage())).build()
    } else {
	      return Response.status(500)
	          .entity(new ApiResponse(code = 500,message = "something bad happened"))	          
	          .build()
    }
  
  }
  
}

