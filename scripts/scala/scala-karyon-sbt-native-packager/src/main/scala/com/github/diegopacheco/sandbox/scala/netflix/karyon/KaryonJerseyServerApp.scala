package com.github.diegopacheco.sandbox.scala.netflix.karyon

import com.netflix.governator.annotations.Modules;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrap;
import netflix.karyon.eureka.KaryonEurekaModule;
import netflix.karyon.jersey.blocking.KaryonJerseyModule;
import netflix.karyon.servo.KaryonServoModule;

@ArchaiusBootstrap
@KaryonBootstrap(name = "weather-service", healthcheck = classOf[HealthcheckResource])
@Modules(include = Array(
        classOf[ShutdownModule],
        classOf[KaryonWebAdminModule],
        classOf[KaryonServoModule],
        classOf[KaryonJerseyModuleImpl],
        classOf[KaryonEurekaModule] 
))
trait KaryonJerseyServerApp {
}

class KaryonJerseyModuleImpl extends KaryonJerseyModule {
    def configureServer() {
        bind(classOf[AuthenticationService]).to(classOf[AuthenticationServiceImpl])
        interceptorSupport().forUri("/*").intercept(classOf[LoggingInterceptor])
        interceptorSupport().forUri("/weather").interceptIn(classOf[AuthInterceptor])
        server().port(6002).threadPoolSize(400)
    }
}
