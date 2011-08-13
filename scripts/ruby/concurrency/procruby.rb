require 'rubygems'

p = Proc.new { |x = "NO"|
   puts "My proc kicks ass..."
   puts "Hm... there is a parameter #{x}"
}

p.call()
p.call("Diego Pacheco")