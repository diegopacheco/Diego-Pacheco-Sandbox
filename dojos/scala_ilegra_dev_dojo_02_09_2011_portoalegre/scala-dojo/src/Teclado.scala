class Teclado {
 
  val tecAlpha:Map[Int,String] = Map(1 -> "ABC")
  
  def clicka(num:Int):String = {
	if (num == 2)	  
	  "DEF"
	else if (num == 3)
	  "GHI"
	else if (num == 4)
	  "JKL"
	else { 

	  //
	  // Opcao 1 : O MAP em escala não é o mesmo mapa de Java. Quando nos fazemos
	  // Map( chave -> valor ) estamos criando: scala.collection.immutable.Map
	  // para fazer o simples get simpliesmente faça mapa(chave) conforme no
	  // codigo a baixo (descomente a 2 linha a baixo para ver).
	  //
	  
	  // tecAlpha(1)

	  // 
	  // Opcao 2: User o Typer Matcher de Scala ( Eh como se fosse um switch mais poderoso )
	  // neste caso usamos o metodo get, que ira retornar um Option[TipoDoValorDoMap] no nosso
	  // caso temos um mapa definido assim: val tecAlpha:Map[Int,String] = Map(1 -> "ABC")
	  // logo a chave do mapa eh um Int e o valor eh uma String, logo quando voce dah um get
	  // no mapa vai retornar um Option[String] isso serve para podermos aplicar o type
	  // matcher do scala. Option em scala herda da classe Product a qual tem alguns metodos
	  // onteresantes como recuperar o valor do option. No caso em questao nao estamos lidando
	  // com array ou collection mas o Product suporta um array ou collection entao temos que 
	  // especificar que queremos o primeiro elemento, e neste caso unico, fazemos isso atravez
	  // do codigo o.productElement(0) mas isso vai retornar Any que eh um tipo novo que existe em 
	  // scala que significa qualquer cosia, logo precisamos fazer um type cast para String, 
	  // fazemos isso assim: variavel.asInstanceOf[String]
	  // 
	  // ... algums referencias sobre type match aqui:
	  //
	  //  - http://kerflyn.wordpress.com/2011/02/14/playing-with-scalas-pattern-matching/
	  //  - http://stackoverflow.com/questions/1806162/pattern-matching-on-a-series-of-values-in-scala
	  //  - http://www.scala-lang.org/node/877
	  //
	  //  Referencia ao Scala DOC(JavaDoc no estilo de funcoes - Scala):
	  //     
	  //    -  scala.collection.immutable.Map
	  //       http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Map
	  //
	  //    -  Option
	  //       http://www.scala-lang.org/api/current/scala/Option.html
	  //
	  //    - Product
	  //       http://www.scala-lang.org/api/current/scala/Product.html   
	  //
	  //  O codigo a baixo mostra em pratica essa explicacao (Descomente para ver o codigo funcionando)
	  //
	  
//	  tecAlpha.get(1) match {
//	    case o: Option[String] => { return o.productElement(0).asInstanceOf[String] }
//	  }
	  	  
	  //
	  // Opcao 3: Usar o metodo GET de dentro do Option, assim o codigo fica um pocuo
	  // mais simples, todas as regras explicadas na opcao 2 ainda sao validas.
	  // vamos ver como fica o codigo, preste atencao nas minhas a baixo, na 
	  // verde o codigo mudou de: return o.productElement(0).asInstanceOf[String]
	  // para: return o.get
	  
//    tecAlpha.get(1) match {
//	    case o: Option[String] => { return o.get }
//	  }

	  //
	  // Opcao 4: Como nao vamos fazer nehuma validacao e processamento extra
	  // ou seja, soh queremos retornar o que esta dentro do mapa
	  // podemos pular a parte do typer matcher e fazer o segunda get no
	  // proprio Option retornado no mapa, conforme o codigo a baixo
	  // lembrando que em scala e o *return* eh opcional, ele retorna a ultima linha de codigo
	  
	  tecAlpha.get(1).get
	  
	}
	
  }
  
}