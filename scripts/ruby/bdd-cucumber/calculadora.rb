class Calculadora

	def push(n)
		@args ||= []
		@args << n
	end
	
	def soma
	   @args[0] + @args[1]
	end	
	
	def subtracao
	   @args[0] - @args[1]
	end
	
	def divisao
		@args[0] / @args[1]
	end
	
	def multiplicacao
		@args[0] * @args[1]
	end

end