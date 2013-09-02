package com.github.diegopacheco.scala.playground.swagger.app

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider

@Provider
@Produces(Array(MediaType.APPLICATION_JSON))
class JacksonJsonProvider(var commonMapper:ObjectMapper = null) extends JacksonJaxbJsonProvider {
	
	def initMapper():ObjectMapper = {
	    if(commonMapper == null) {
	        var mapper:ObjectMapper = new ObjectMapper()
	    	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
	    	mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT)
	    	mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
	    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	    	return mapper
	    } else {
	        return commonMapper
	    }
	}
  
	def this() = this( commonMapper = initMapper() )
 
}