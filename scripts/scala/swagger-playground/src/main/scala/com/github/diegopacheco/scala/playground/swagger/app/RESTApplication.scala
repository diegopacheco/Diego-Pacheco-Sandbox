package com.github.diegopacheco.scala.playground.swagger.app

import com.wordnik.swagger.annotations._
import com.wordnik.swagger.jaxrs._

import com.sun.jersey.api.core._
import javax.ws.rs._


@Path("/resources.json")
@Api("/resources")
@Produces(Array("application/json"))
class ApiListingResource extends ApiListing {}


class RESTApplication extends PackagesResourceConfig {
  def this(pkg: String*) = {
    this
  }
}


@Path("/pet.json")
@Api(value = "/pet", description = "Operations about pets")
@Produces(Array("application/json"))
class PetResource {
  

  @GET
  @Path("/{petId}")
  @ApiOperation(value = "Find pet by ID", notes = "Add extra notes here", responseClass = "com.wordnik.swagger.sample.model.Pet")
  @ApiErrors(Array(
    new ApiError(code = 400, reason = "Invalid ID supplied"),
    new ApiError(code = 404, reason = "Pet not found"))
  )
  def getPetById(
    @ApiParam(value = "ID of pet that needs to be fetched", required = true, allowableValues="range[0,10]")@PathParam("petId") petId: String) 
  = {
    /* your resource logic */
  }
  

}
