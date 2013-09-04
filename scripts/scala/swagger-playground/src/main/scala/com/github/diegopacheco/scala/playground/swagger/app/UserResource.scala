package com.github.diegopacheco.scala.playground.swagger.app

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiErrors
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import javax.xml.bind.annotation.XmlRootElement
import com.wordnik.swagger.annotations.ApiError

@Path("/user")
@Api(value="/user", description = "Operations about user")
@XmlRootElement(name = "Pet")
@Produces(Array("application/json","application/xml"))
class UserResource {

  @Path("/create")
  @GET
  @ApiOperation(value = "Create User", notes = "More notes about this method")
  @ApiErrors(value = Array(
      new ApiError(code = 400, reason = "Invalid ID supplied"),
      new ApiError(code = 404, reason = "Pet not found") 
  ))
  def createUser(@ApiParam(value = "Created name of the user", required = true) name:String):Response = {
	println("Saved with sucess!")  
    return Response.ok().entity("OK").build()
  }
  
}