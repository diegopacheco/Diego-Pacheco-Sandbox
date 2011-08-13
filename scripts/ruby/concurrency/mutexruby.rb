require 'rubygems'

def add1(value)
	value + 1
end

mutex = Mutex.new
n     = 40

2.times do
	Thread.new {
	    5.times {
		     mutex.synchronize {
				n = add1(n)
			 }			 
		}
	}
end

puts "N is #{n}"
