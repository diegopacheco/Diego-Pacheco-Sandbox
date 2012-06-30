package com.github.diegopacheco.sandbox.scala.camel.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.ShutdownRunningTask
import org.apache.camel.model.RouteDefinition

class PojoRouteBuilder extends RouteBuilder {

    override def configure():Unit = {
          from("bean:start").id("r1").startupOrder(1).
        	to("bean:middle").
        	to("bean:wab").
            to("bean:end").
            to("bean:stop?method=stopItNow(r1)");
    }

}