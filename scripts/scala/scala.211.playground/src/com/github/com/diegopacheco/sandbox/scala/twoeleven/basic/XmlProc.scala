package com.github.com.diegopacheco.sandbox.scala.twoeleven.basic

object XmlProc extends App {
	
  import scala.xml._
  
  val page = 
  <html>
    <head>
      <title>Hello XHTML world</title>
    </head>
    <body>
      <h1>Hello world</h1>
      <p><a href="scala-lang.org">Scala</a> talks XHTML</p>
    </body>
  </html>;
  println(page.toString())
 
}