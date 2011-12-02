require 'rubygems'
require 'active_support'

class Pessoa
  
  @nome
  @email
  
  attr_reader :nome, :email 
   
  def initialize(nome,email)    
    @nome = nome
    @email = email
  end 
    
  def to_s
    return "nome: #{@nome} email: #{@email}"
  end 
  
  def to_json
    return ActiveSupport::JSON.encode(self)
  end
  
end