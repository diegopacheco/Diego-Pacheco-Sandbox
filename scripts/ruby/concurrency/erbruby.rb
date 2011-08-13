require 'rubygems'
require 'erb'

##
##  Simple ERB Usage
##

template = ERB.new('<%= "Hello World ERB" %>')
puts template.src

erb = ERB.new('<%= "Hello World ERB" %>', nil, nil, 'self')
puts erb.src

# Small monckey patch that make ERB dont generate the self = '', so it dont define self
# and we can define self our selfs :-)
class ERB::Compiler
	def pre_cmd= x; end
end

e = ERB.new('<%= "Hello World ERB" %>', nil, nil, 'self')
puts e.src

##  
## ERB + Pipe now =)
##

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

# StdOut is the Sync
class StdOut < Pipe
	def write value
		puts value
	end
end

# This make a ERB a Pipe, so you can put ruby code templates in the pipeline
# PipERB will act like a generator
class  PipERB < Pipe
	
	def initialize data
		super()
		@erb = ERB.new(data, nil, nil, 'self')
	end
	
	alias :concat :process
	
	def read; @erb.result(binding) end
	def force_encoding encoding;   end

end

( PipERB.new("<%= 'Hi From Ruby ERB' %>") | StdOut.new).resume