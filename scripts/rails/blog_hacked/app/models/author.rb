class Author < ActiveRecord::Base	
  # Include default devise modules. Others available are:
  # :token_authenticatable, :confirmable, :lockable and :timeoutable  :registerable,
  devise :database_authenticatable, :recoverable, :rememberable, :trackable, :validatable

  # Setup accessible (or protected) attributes for your model
  attr_accessible :name, :age, :email, :password, :password_confirmation, :remember_me
	
	has_many :posts
	
	validates :name, :age, :presence => true

end
