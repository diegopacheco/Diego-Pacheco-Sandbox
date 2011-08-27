# language: pt
Funcionalidade: deposito
  Para efetuar um deposito simples na conta corrente
  Como uma forma de depositar e guardar dinheiro na sua conta corrente
  Eu quero poder depositar dinheiro na conta corrente

  Cenario: 1 depositar 500 reais
    Dado 1 que eu depositei 500 na conta corrente
    Entao 1 o meu saldo deve ter 500 reais
    
  Cenario: 2 depositar 500 reais quando ja tem saldo de 200
    Dado 2 que eu depositei 500 reais e ja tinha 200 reais
    Entao 2 o meu saldo agora deve ser 700 reais
    
  Cenario: 3 depositar 500 reais quando tem saldo -200
    Dado 3 que eu depositei 500 reais e tinha -200
    Entao 3 o meu saldo era negativo e agora deve ser 300