require 'lib/CC'

Before do
  @cc = CC.new
  @valor = 0
end

After do
  @cc.cleanup
end

Dado /^1 que eu ja tinha (\d+) reais e saquei (\d+)$/ do |valor_saldo, sacar|
  @cc.deposit valor_saldo.to_i
  @valor =  sacar.to_i
end

Entao /^1 o meu saldo deve ser (\d+) reais$/ do |saldo_cc|
  @saldo = @cc.withdraw @valor
  @saldo.should == saldo_cc.to_i
end


Dado /^2 que eu ja tinha (\d+) reais e queria sacar (\d+) reais$/ do |valor_saldo, sacar|
  @cc.deposit valor_saldo.to_i
  @valor = sacar.to_i
end

Entao /^2 o CC deve jogar uma exception na minha cara$/ do
  lambda {
    @cc.withdraw @valor
  }.should raise_error(RuntimeError)
end