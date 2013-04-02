package com.github.diegopacheco.sandbox.scala.caseclasses

import scala.beans.BeanProperty

case class Pessoa(@BeanProperty var nome:String, 
				  @BeanProperty var Endereco:String = "centro", 
				  @BeanProperty var telefone:Int = 0)

object CaseClassMain extends App {
	println( Pessoa(nome = "Diego").getNome )
}

