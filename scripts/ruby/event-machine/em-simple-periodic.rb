require 'rubygems'
require 'eventmachine'

puts "start"
EM.run do
	puts "init"
	EM.add_periodic_timer(1) do
		puts "queuing..."
	end	
end
puts "end"

# $ ruby em-simple-periodic.rb
# start
# init
# queuing...
# queuing...
# queuing...
# queuing...
# queuing...
# queuing...
# queuing...


