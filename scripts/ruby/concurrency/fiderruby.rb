require 'rubygems'

f = Fiber.new { |p = 0|
   puts "My Fiber #{p}"
   p
}

v = f.resume(200)
puts v

begin
	f.resume(150)
rescue FiberError => fe
	p fe
end	
