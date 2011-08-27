class CC
  
  @@saldo = 0
  
  def deposit(valor)
      @@saldo = valor + @@saldo
  end
  
  def withdraw(valor)
     raise "Voce nao tem saldo para sacar o valor de: #{valor}" unless valor < @@saldo
     @@saldo = @@saldo - valor  
  end
  
  def saldo
    @@saldo
  end
  
  def cleanup
    @@saldo = 0
  end
  
end