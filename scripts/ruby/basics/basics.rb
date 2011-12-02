#
# Function that receives number by parameter and use the for statement in order to show the timetable
#
def tabuada(numero)  
   for i in 1..10 
     puts "#{i} x #{numero} == #{i * numero}"
   end    
end

#
# Function that do the timetable for number 2 using the clojure each for arrays
#
def clojureTabuada
  (1..10).each { |it|
    puts "#{it} x #{2} == #{2 * it}"  
  }
end

#
# I'm just playing with maps
#
def testMap
  
  cidades = {
     "RS" => "POA",
     "RJ" => "RJ",
     "SP" => "SAO",
  }
  
  cidades.each { |k,v|
    puts "Estado: #{k} capital: #{v}"
  }
  
  puts cidades['SP']
  
end

#
# I'm just playing with simple ifs here.
#
def bigger(x,y)
  if x >y
    return x
  else
    return y
  end
end

