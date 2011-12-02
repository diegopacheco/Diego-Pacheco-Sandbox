require 'rubygems'
require 'active_support'
require 'sinatra_fun/domain/pessoa'

class Tweet
  
  @message
  @pessoa
  
  attr_reader :message, :pessoa 
   
  def initialize(pessoa,message)    
    @pessoa  = pessoa
    @message = message    
  end 
    
  def to_s
    return "Pessoa: #{@pessoa} Message: #{@message}"
  end 
  
  def to_json
    return ActiveSupport::JSON.encode(self)
  end
  
end