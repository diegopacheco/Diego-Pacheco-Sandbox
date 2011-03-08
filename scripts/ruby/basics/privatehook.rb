class Hehe
  
  def publicmethod
    return "bla bla"
  end
  
  private
  
  def thisIsPrivate
    return "private"
  end
  
end

o = Hehe.new
puts o.publicmethod
puts o.send(:thisIsPrivate)