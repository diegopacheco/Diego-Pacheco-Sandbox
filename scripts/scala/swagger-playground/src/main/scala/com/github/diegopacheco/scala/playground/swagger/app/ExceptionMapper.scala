package com.github.diegopacheco.scala.playground.swagger.app

import javax.ws.rs._
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response
import javax.ws.rs.ext._
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import scala.beans.BeanProperty
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.XmlAttribute

@Provider
class SwaggerScalaExceptionMapper extends ExceptionMapper[Exception] {

  def toResponse(ex: Exception): Response = {

    if (ex != null && ex.isInstanceOf[WebApplicationException]) {
      var e: WebApplicationException = ex.asInstanceOf[WebApplicationException]
      return Response
        .status(e.getResponse().getStatus())
        .entity(ex.getMessage)
        .build()
    } else {
      return Response.status(500)
        .entity("something bad happened")
        .build()
    }

  }

}
