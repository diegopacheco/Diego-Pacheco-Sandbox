require 'rubygems'

l  = [1,2,3]
it = Enumerator.new(l)

begin
	puts it.next
	puts it.next
	puts it.next
	puts it.next
rescue StopIteration => e
	puts e.result
end	

l2  = ['A','B','C']
it2 = Enumerator.new(l2)
it2.each { |i2|
   puts i2	
}