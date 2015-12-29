package com.github.diegopacheco.sandbox.scala.netflix.karyon.rest

import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import org.codehaus.jettison.json.JSONException
import org.codehaus.jettison.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource
import com.sun.jersey.api.client.config.ClientConfig
import com.sun.jersey.api.client.config.DefaultClientConfig
import scala.collection.JavaConversions

@Singleton
@Path("/weather")
class WeatherResource {
    
    import scala.collection.JavaConversions._
    val logger:Logger = LoggerFactory.getLogger(classOf[WeatherResource])
  
	  @GET
    @Path("now/{location}")
    @Produces(value=Array(MediaType.APPLICATION_JSON))
    def sum(@PathParam("location")location:String):Response  = {
	      try {
        	
        	  var cc:ClientConfig = new DefaultClientConfig();
        	  cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, java.lang.Boolean.TRUE)
        	  var c:Client = Client.create(cc)
        	  var r:WebResource = c.resource("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=2de143494c0b295cca9337e1e96b00e0")
    	      
        	  r.accept(MediaType.APPLICATION_JSON_TYPE).get(classOf[String])
    	      var cr:ClientResponse = r.get(classOf[ClientResponse])
    	      var entity:String = cr.getEntity(classOf[String])
    	      
         	  var response:JSONObject  = new JSONObject()
            response.put("weather",  entity)
          
            return Response.ok(response.toString()).build()
        } catch {
          case e:JSONException => 
              logger.error("Error creating json response.", e)
              return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
        }
	  }
  
}