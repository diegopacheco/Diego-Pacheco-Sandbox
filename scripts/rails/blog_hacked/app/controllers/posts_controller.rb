class PostsController < ApplicationController
	respond_to :html, :atom, :only => [:index, :show]
	
	before_filter :authenticate_author!, :except => [:index, :show]
	before_filter :sweep_cache, :only => [:create,:update,:destroy]
	caches_action :index
	
	def index
		@posts = Post.past
		respond_with @posts
	end
	
	def queue
		@posts = Post.future
		respond_with @posts do |format|
			format.html { render "index" }
		end
	end
	
	def show
		@post = Post.find(params[:id])
		respond_with @post
	end
	
	def new
		@post = Post.new
	end
	
	def create
		@post = current_author.posts.build(params[:post])
		@post.save
		respond_with(@post) 
	end
	
	def edit
		@post = Post.find(params[:id])
	end
	
	def update
		@post = Post.find(params[:id])
		@post.update_attributes(params[:post])
		respond_with(@post)
	end
	
	def destroy
	   @post = Post.find(params[:id])
	   @post.destroy
	   respond_with(@post)
	end
	
	private 
	
	def sweep_cache
		expire_action :action => :index
	end
	
end
