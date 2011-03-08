proglangs = {
   :java  => "Cool",
   :ruby  => "Coler",
   :scala => "Awesome" 
}

proglangs.each { |l,c| 
  puts "Language [#{l}] is #{c}"
}

puts :java

puts proglangs[:scala]
