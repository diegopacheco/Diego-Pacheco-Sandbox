 require 'rubygems'
 require 'open-uri'

 open( "http://www.google.com/search?q=truck" ) do |truck|
   puts truck.read
 end