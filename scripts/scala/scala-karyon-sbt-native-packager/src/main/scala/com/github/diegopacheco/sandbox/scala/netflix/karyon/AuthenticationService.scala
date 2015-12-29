package com.github.diegopacheco.sandbox.scala.netflix.karyon

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

trait AuthenticationService {
    def authenticate(request:HttpServerRequest[ByteBuf]):Observable[Boolean];
}