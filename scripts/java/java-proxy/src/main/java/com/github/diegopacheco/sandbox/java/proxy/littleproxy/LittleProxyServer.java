package com.github.diegopacheco.sandbox.java.proxy.littleproxy;

import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

public class LittleProxyServer {
	public static void main(String[] args) {

		HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(8888)
				.withFiltersSource(new HttpFiltersSourceAdapter() {
					public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
						return new HttpFiltersAdapter(originalRequest) {
							@Override
							public HttpResponse clientToProxyRequest(HttpObject httpObject) {
								System.out.println("clientToProxyRequest");
								System.out.println(httpObject);
								System.out.println("******");
								return null;
							}
							@Override
							public HttpObject serverToProxyResponse(HttpObject httpObject) {
								System.out.println("serverToProxyResponse");
								System.out.println(httpObject);
								System.out.println("******");
								return httpObject;
								
							}
						};
					}
	   }).start();
	   System.out.println(server.toString());

	}
}
