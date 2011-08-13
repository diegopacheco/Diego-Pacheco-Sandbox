require 'rubygems'

# Pipeline class Abstraction
class Pipe < Struct.new(:source)
	
	def initialize(source = nil)
	   super
	   @fiber = Fiber.new {
			self.loop
	   }
	end
	
	def loop
		while value = read
			process value
		end
	end
	
	def read; source.resume              end
	def write(value); Fiber.yield(value) end
	def process(value); write(value)     end
	def resume; @fiber.resume            end
	
	def |(other)
		other.source = self
		other
	end
	
end

# Infinity is a Generator
class Infinity < Pipe
	def loop
		i = 1
		while true
			write i
			i +=  i
		end
	end
end

# Infinity is a Filter
class Evens < Pipe
	def process(value)
		super if value % 2 == 0
	end
end

# StdOut is the Sync
class StdOut < Pipe
	def write value
		puts value
	end
end

#### Connecting all together
#### first boring syntax...
# infinity = Infinity.new
# even     = Evens.new infinity
# stdout   = StdOut.new even
# stdout.resume

#Nice Syntax
(Infinity.new | Evens.new | StdOut.new).resume

