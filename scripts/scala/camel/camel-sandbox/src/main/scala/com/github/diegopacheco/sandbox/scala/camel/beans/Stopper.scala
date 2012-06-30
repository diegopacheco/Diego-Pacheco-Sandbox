package com.github.diegopacheco.sandbox.scala.camel.beans

import org.apache.camel.impl.DefaultCamelContext
import scala.reflect.BeanProperty

class Stopper {
	
	@BeanProperty var camelCtx:DefaultCamelContext = null
	
    def stopItNow(route:String):Unit = {
        camelCtx.stopRoute(route);
    }
    
}