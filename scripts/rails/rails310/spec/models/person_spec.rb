require 'spec_helper'

describe Person do
	
	it "should create a Person right" do
	    attr = {
			:name      => "Diego Pacheco",
			:twitter   => "@diego_pacheco",
			:born      => 1984 
		}
		person = Person.new(attr)		
		person.name.should eq("Diego Pacheco")		
	end
	
	it "should create a Person right2 " do
	    attr = {
			:name      => "Diego Pacheco 2",
			:twitter   => "@diego_pacheco2",
			:born      => 19842 
		}
		person = Person.new(attr)		
		person.name.should eq("Diego Pacheco2")		
	end
	
end
