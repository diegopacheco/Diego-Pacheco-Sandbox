require 'rubygems'
require 'twitter'

puts "Tendencias do Twitter"
Twitter::Trends.current.each { |tweet| 
  puts tweet.name 
}

puts "Search"
Twitter::Search.new('nodilma').each do |r| 
  puts " Usuário: #{r.from_user}  -  tweet: #{r.text}"
end

