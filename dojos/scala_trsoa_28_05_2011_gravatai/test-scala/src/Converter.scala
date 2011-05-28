object Converter {  
	var mapa = Map(1  -> "I",
				   2  -> "II",
				   3  -> "III",
				   4  -> "IV",
				   5  -> "V",
				   6  -> "VI",
				   7  -> "VII",
				   8  -> "VIII",
				   9  -> "IX",
				   10 -> "X"
	)
	def toRoman(valor:Int) : String = {
        if( valor <= 10) 
			mapa (valor)
		else if (valor <= 20)
			"X" + mapa (valor - 10)
		else if (valor <= 30)
			"XX" + mapa(valor - 20)
		else if (valor <= 40)
			"XXX" + mapa(valor - 30)
		else
			throw new UnsupportedOperationException(valor + " is not supported!")
	}
}
