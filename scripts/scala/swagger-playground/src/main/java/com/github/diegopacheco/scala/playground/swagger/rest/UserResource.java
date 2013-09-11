package com.github.diegopacheco.scala.playground.swagger.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces("application/json")
public class UserResource {
	
	  @Path("/create/{name}")
	  @GET
	  @ApiOperation(value = "Create User", notes = "More notes about this method")
//	  @ApiResponses(value = {
//					  @ApiResponse(errors = @ApiError(code = 400, reason = "Invalid name supplied")),
//					  @ApiResponse(errors = @ApiError(code = 404, reason = "User not found"))
//	  })
	  public Response createUser( @ApiParam(name = "name", value = "Created name of the user") @PathParam(value = "name") String  name) {
	     return Response.ok().entity("<html><body>DONE</body></html>").build();
	  }
	
}
