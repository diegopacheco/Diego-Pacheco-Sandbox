Before do
  @calc = Calculadora.new
end
 
After do
end
 
Dado /que eu digitei (\d+) na calculadora/ do |n|
  @calc.push n.to_i
end
 
Quando 'eu aperto o botao de soma' do
  @result = @calc.soma
end

Quando 'eu aperto o botao de subtracao' do
  @result = @calc.subtracao
end

Quando 'eu aperto o botao de divisao' do
  @result = @calc.divisao
end

Quando 'eu aperto o botao de multiplicacao' do
  @result = @calc.multiplicacao
end
 
Entao /o resultado na calculadora deve ser (\d*)/ do |result|
  @result.should == result.to_i
end