require 'rubygems'
require 'test/unit'
require 'EventSystem'

class EventTest < Test::Unit::TestCase
    
    public
  
    def test_people_igor
      igor = Person.new("Igor")
      assert_equal(igor.name, "Igor")      
    end
    
    def test_register_igor_event_devopsday
      event  = Event.new("1st DevOps Day")
      person = Person.new("Igor")
      event.add_person(person)
      assert_equal(event.people[0].name, "Igor")
    end
    
    def test_register_charao_igor_devopsday
      event = Event.new("devops day")
      igor = Person.new("Igor")
      charao = Person.new("Charao")
      event.add_person(igor)
      event.add_person(charao)
      assert_equal(event.people.length, 2)
    end
      
    def test_register_event_section
      event = Event.new("Devops Day")
      event.add_section("dojo")
      assert_equal(event.section[0], "dojo")
    end
    
    def test_register_several_sections
      event = Event.new("DevOps Day")
      event.add_section("NoSQL")
      event.add_section("Ruby Dojo")
      assert_equal(event.section.length, 2)
    end
    
end