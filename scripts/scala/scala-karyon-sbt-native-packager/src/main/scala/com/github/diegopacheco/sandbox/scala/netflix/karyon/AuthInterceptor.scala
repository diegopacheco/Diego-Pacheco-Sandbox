package com.github.diegopacheco.sandbox.scala.netflix.karyon

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import javax.inject.Inject;
import netflix.karyon.transport.interceptor.InboundInterceptor;
import rx.Observable;
import rx.functions.Func1;

class AuthInterceptor 
  extends InboundInterceptor[HttpServerRequest[ByteBuf], HttpServerResponse[ByteBuf]] {
    
    @Inject
    var authService:AuthenticationService = null
  
    def in(request:HttpServerRequest[ByteBuf], response:HttpServerResponse[ByteBuf]):Observable[Void] = {
        return authService.authenticate(request).map(new Func1[Boolean, Void]() {
            def call(aBoolean:Boolean):Void = {
                null
            }
        })
    }
}