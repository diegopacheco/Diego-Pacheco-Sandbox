package com.github.diegopacheco.sandbox.scala.camel.routes

import org.apache.camel.builder.RouteBuilder
import org.apache.camel.ShutdownRunningTask
import org.apache.camel.model.RouteDefinition

class PojoRouteBuilder extends RouteBuilder {

    override def configure():Unit = {
        from("bean:start").id("r1").to("bean:end").to("bean:stop?method=stopItNow(r1)");
    }

}