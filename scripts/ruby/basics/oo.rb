#
# Class pessoa, basic oo stuff
#
class Pessoa
  
  @nome
  @dataNasc
  @email  

  # generate getter based only on method name: i.e: nome
  attr_reader :nome, :dataNasc, :email

  # This is the constructor
  def initialize(nome,dataNasc,email)
    @nome = nome
    @dataNasc = dataNasc
    @email = email
  end
  
  # toString
  def to_s
    return "nome: #{@nome} dataNasc: #{@dataNasc} email: #{@email}"
  end
  
  # getter for reading only
  def acces_nome
    @nome
  end

  
end

p = Pessoa.new("Diego","18/12/1984","d@d.com")
puts p.nome

