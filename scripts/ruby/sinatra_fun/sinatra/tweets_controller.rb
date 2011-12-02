require 'rubygems'
require 'sinatra'
require 'sinatra_fun/service/tweets_service'

get '/tweets.json' do
  return TWEET_SERVICE.all_tweets()  
end