# language: pt
Funcionalidade: saque
  Para efetuar um saque simples na conta corrente
  Como uma forma de sacar dinheiro para comprar cerveja
  Eu quero poder tomar muitas cervejas com o dinheiro que eu saquei da conta corrente
  
  Cenario: 1 sacar 300 reais
  	Dado 1 que eu ja tinha 1000 reais e saquei 300
  	Entao 1 o meu saldo deve ser 700 reais
  	
  Cenario: 2 sacar 400 reais
    Dado 2 que eu ja tinha 390 reais e queria sacar 400 reais
    Entao 2 o CC deve jogar uma exception na minha cara	