line1 = "Cats are smarter than dogs";
line2 = "Dogs also like meat";

if ( line1 =~ /Cats(.*)/ )
  puts "Line1 starts with Cats"
end
if ( line2 =~ /Cats(.*)/ )
  puts "Line2 starts with Dogs"
end
