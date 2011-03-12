 def yield_thrice
   yield
   yield
   yield
 end
 
a = ['first, birth.', 'then, a life of flickering images.', 'and, finally, the end.']
yield_thrice { 
  puts a.shift 
}