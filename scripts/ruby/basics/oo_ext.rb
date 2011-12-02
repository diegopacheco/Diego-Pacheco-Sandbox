require 'src/oo'

class Developer < Pessoa
  
  @cpf
  @favoriteLanguage = "Java"
  
  attr_reader :cpf, :favoriteLanguage
  
  def initialize(nome, dataNasc, email,cpf,favoriteLanguage)
    super(nome,dataNasc,email)
    @cpf = cpf
    @favoriteLanguage = favoriteLanguage
  end
  
  def to_s
     "#{super.to_s} | #cpf: #{@cpf}, fav. language: #{@favoriteLanguage}"
  end
  
end

d = Developer.new("Diego","18/12/1984","d@d.com","1012347849","Java")
puts d