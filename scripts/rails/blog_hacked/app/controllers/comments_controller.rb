class CommentsController < ApplicationController
	
	before_filter :authenticate_author!, :only => :destroy
	
	def create
		post = Post.find(params[:post_id])
		post.comments.create(params[:comment])
		redirect_to post
	end
	
	def destroy
	   post = Post.find(params[:post_id])
	   comment = Comment.find(params[:id])
	   comment.destroy
	   redirect_to post
	end
	
end
