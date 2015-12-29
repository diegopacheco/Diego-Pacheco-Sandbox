package com.github.diegopacheco.sandbox.scala.netflix.karyon

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

class AuthenticationServiceImpl extends AuthenticationService {

	val AUTH_HEADER_NAME:String  = "MY-USER-ID";

    @Override
    def authenticate(request:HttpServerRequest[ByteBuf]):Observable[Boolean] = {
        if (request.getHeaders().contains(AUTH_HEADER_NAME)) {
            return Observable.just(java.lang.Boolean.TRUE)
        } else {
            return Observable.error(new IllegalArgumentException("Should pass a header: " + AUTH_HEADER_NAME))
        }
    }
}
