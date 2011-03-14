class PostsController < ApplicationController
	respond_to :html, :atom
	
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
		@post = Post.new(params[:post])
		
		if @post.save 
			redirect_to posts_path
		else 	
			render "new"
		end		
	end
	
	def edit
		@post = Post.find(params[:id])
	end
	
	def update
		@post = Post.find(params[:id])
		if @post.update_attributes(params[:post])
		   redirect_to posts_path
		else
		   render "edit" 	
		end  
	end
	
	def destroy
	   post = Post.find(params[:id])
	   post.destroy
	   redirect_to posts_path, :notice => "#{post.tittle} was deleted"
	end
	
	private 
	
	def sweep_cache
		expire_action :action => :index
	end
	
end
