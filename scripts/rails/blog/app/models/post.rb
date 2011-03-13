class Post < ActiveRecord::Base
	
	has_many :comments
	
	validates_presence_of :tittle
	validates_presence_of :body

end
