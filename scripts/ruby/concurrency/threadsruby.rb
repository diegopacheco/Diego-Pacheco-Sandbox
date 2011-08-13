require 'rubygems'

# Create a Thread that return 101
t = Thread.new {
  puts "Say hi from the thread"
  101  
}

# Block the thread(value calls join method) and get the return(101)
v = t.value
puts "Thread Result was #{v}"

# Create 10 Threads
10.times { |i| 
	Thread.new { 
		puts "hi #{i}" 
	} 
}

#Get the list of all threads and subtract the main thread and join then all
(Thread.list - [Thread.main]).each { |t|
   t.join
}
