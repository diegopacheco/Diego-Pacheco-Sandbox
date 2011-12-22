class Person

  attr_accessor :name
  
  def initialize(name="")
    @name = name
  end
  
  def to_s
    @name
  end
  
end

class Event
  
  attr_accessor :name, :people, :section
  
  def initialize(name="")
    @name = name
    @people = []
    @section = []
  end
  
  def to_s
    @name
  end
  
  def add_person(person)
    @people << person     
  end
  
  def add_section(section)
    @section << section
  end
end