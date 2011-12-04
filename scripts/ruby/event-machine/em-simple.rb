require 'rubygems'
require 'eventmachine'

puts "start"
EM.run do
	puts "init"
	EM.add_periodic_timer(1) do
		puts "queuing..."
		EM.stop_event_loop
	end	
end
puts "end"

# $ ruby em-simple.rb
# start
# init
# queuing...
# end

