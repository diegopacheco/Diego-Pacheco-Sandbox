package com.github.diegopacheco.sandbox.scala.netflix.karyon

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import netflix.karyon.health.HealthCheckHandler;

@Path("/healthcheck")
class HealthcheckResource extends HealthCheckHandler{
	
    @GET
    @Produces(Array(MediaType.APPLICATION_JSON))
    def healthcheck():Response = {
        return Response.status(getStatus()).build()
    }

	  def getStatus():Int =  {
	  	return 200;
	  }
	
}
