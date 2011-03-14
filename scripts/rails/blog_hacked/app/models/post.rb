class Post < ActiveRecord::Base
	
	belongs_to :author
	has_many   :comments
		
	scope :desc, order("published_on desc").includes(:author)
	scope :asc , order("published_on asc").includes(:author)
	
	validates_presence_of :tittle
	validates_presence_of :body
	
	def self.past
		where("published_on <= ?",Date.today).desc
	end
	
	def self.future
		where("published_on > ?",Date.today).asc
	end

end