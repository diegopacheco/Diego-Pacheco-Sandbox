package com.github.diegopacheco.scala.playground.swagger.app

import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse
import javax.servlet.FilterConfig

class ApiOriginFilter extends javax.servlet.Filter {
	
    override def doFilter(request:ServletRequest , response:ServletResponse ,chain:FilterChain):Unit = {
       val res:HttpServletResponse  =  response.asInstanceOf[HttpServletResponse]
       res.addHeader("Access-Control-Allow-Origin", "*");
       res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
       res.addHeader("Access-Control-Allow-Headers", "Content-Type");
       chain.doFilter(request, response);
    } 
    
    override def destroy():Unit = {}
    override def init(filterConfig:FilterConfig):Unit = {}
}