class PepsiMachine

	@@products = {"pepsi" => 1, "guarana" => 2}
	@money
	
	
    public
    
	def pay(value)
		@money = value
		self
	end
	
	def take(product)
        if(@@products[product] == @money)
			return product
		end
		"erro" 
    end
  
end