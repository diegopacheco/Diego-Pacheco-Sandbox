 class NameCaller
   def method_missing( name, *args )
     puts "You're calling '#{name}' and you say:" 
     args.each { |say| puts "  #{say}"}
     puts "But no one is there yet." 
   end
end
   
NameCaller.new.simon( 'Hello?', 'Hello? Simon?' )