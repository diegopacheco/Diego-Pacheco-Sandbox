package com.github.diegopacheco.scala.playground.swagger.app


import javax.ws.rs.core.Response
import javax.ws.rs._
import com.wordnik.swagger.annotations.ApiParam
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces(Array("application/json"))
class UserResource {

  @POST
  @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.")
  def createUser(@ApiParam(value = "Created name of the user", required = true) name:String):Response = {
	println("Saved with sucess!")  
    return Response.ok().entity("").build()
  }
  
}