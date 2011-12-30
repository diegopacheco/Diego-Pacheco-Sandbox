package com.github.diegopacheco.sandbox.scripts.scala.xml

object ScalaXML extends App {
	
	import scala.xml._
  
	val xml = <Root>
				<People>
					<Person id="1" name="Diego"/>
					<Person id="2" name="Poletto"/>
					<Person id="3" name="Christophe"/>
				</People>
			  </Root>	
	println(xml)	
	
	
	val xmlString = """
			<Root>
				<People>
					<Person id="1" name="Diego"/>
					<Person id="2" name="Poletto"/>
					<Person id="3" name="Christophe"/>
				</People>
			</Root>
	"""
	  
	val x = XML.loadString(xmlString)
	println(x)
	
	println( (x \\ "Person")(0) )
}