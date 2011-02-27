require 'rubygems'
require 'redis'

r = Redis.new
r.set "diegopacheco_1", "first tweet"
puts r.get "diegopacheco_1"