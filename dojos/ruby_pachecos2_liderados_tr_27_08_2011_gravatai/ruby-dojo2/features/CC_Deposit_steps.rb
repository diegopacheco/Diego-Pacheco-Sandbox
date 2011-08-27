require 'lib/CC'

Before do
  @cc    = CC.new
  @valor = 0
end
 
After do
  @cc.cleanup()
end

Dado /^1 que eu depositei (\d+) na conta corrente$/ do |valor_depositar|
  @valor = valor_depositar.to_i
end

Entao /^1 o meu saldo deve ter (\d+) reais$/ do |saldo_cc|
  @saldo = @cc.deposit @valor
  @saldo.should == saldo_cc.to_i
end

Dado /^2 que eu depositei (\d+) reais e ja tinha (\d+) reais$/ do |valor_depositar, saldo_cc|
  @valor = valor_depositar.to_i + saldo_cc.to_i
end

Entao /^2 o meu saldo agora deve ser (\d+) reais$/ do |saldo_cc|
  @saldo = @cc.deposit @valor
  @saldo.should == saldo_cc.to_i
end

Dado /^3 que eu depositei (\d+) reais e tinha \-(\d+)$/ do |valor_deposito, saldo_cc|
  @valor = saldo_cc.to_i * -1
  @cc.deposit valor_deposito.to_i
end

Entao /^3 o meu saldo era negativo e agora deve ser (\d+)$/ do |saldo_cc|
  @saldo = @cc.deposit @valor
  @saldo.should == saldo_cc.to_i
end