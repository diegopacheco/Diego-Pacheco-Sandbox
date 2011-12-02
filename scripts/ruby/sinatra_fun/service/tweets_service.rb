require 'active_support'

require 'sinatra_fun/domain/pessoa'
require 'sinatra_fun/domain/tweet'

class TWEET_SERVICE
  
  def TWEET_SERVICE.all_tweets()
    
    pessoa = Pessoa.new("Diego","diego@pacheco.com")
    lista  = Array.new
    
    tweet1 = Tweet.new(pessoa,"Sinatra rocks!")
    tweet2 = Tweet.new(pessoa,"Json rocks!")
    tweet3 = Tweet.new(pessoa,"Ruby rocks!")
    
    lista << tweet1
    lista << tweet2
    lista << tweet3
    
    return ActiveSupport::JSON.encode(lista)
    
  end
  
end

__END__
TIP: Sinatra + OO + simple json