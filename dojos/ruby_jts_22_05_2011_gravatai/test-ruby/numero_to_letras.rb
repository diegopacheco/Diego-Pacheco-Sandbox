class Integer  
  
  @@alfabeto = [" ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ"]  
  
  def to_letra(num)    
    return @@alfabeto[num] unless @@alfabeto[num] == nil  
    return "ERRO: Numero invalido!"
  end
    
end