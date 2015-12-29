package com.github.diegopacheco.sandbox.scala.netflix.karyon

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import netflix.karyon.transport.interceptor.DuplexInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

class LoggingInterceptor extends DuplexInterceptor[HttpServerRequest[ByteBuf], HttpServerResponse[ByteBuf]] {

    val logger:Logger  = LoggerFactory.getLogger(classOf[LoggingInterceptor])

    var count:Integer = 0;;
    var id:Integer=0;

    count = count + 1
    id = count

    def in(request:HttpServerRequest[ByteBuf],response:HttpServerResponse[ByteBuf]):Observable[Void] = {
        logger.info("Logging interceptor with id {} invoked for direction IN.", id)
        return Observable.empty()
    }

    def out(response:HttpServerResponse[ByteBuf]):Observable[Void] = {
        logger.info("Logging interceptor with id {} invoked for direction OUT.", id);
        return Observable.empty()
    }
}