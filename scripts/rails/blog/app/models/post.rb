class Post < ActiveRecord::Base
	
	has_many :comments
	
	scope :desc, order("published_on desc")
	scope :asc , order("published_on asc")
	
	validates_presence_of :tittle
	validates_presence_of :body
	
	def self.past
		where("published_on <= ?",Date.today).desc
	end
	
	def self.future
		where("published_on > ?",Date.today).asc
	end

end