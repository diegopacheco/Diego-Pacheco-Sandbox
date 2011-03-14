class AuthorsController < ApplicationController

  before_filter :authenticate_author!, :except => [:index, :show]	

  # GET /authors
  # GET /authors.xml
  def index
    @authors = Author.all
    respond_with(@authors)
  end

  # GET /authors/1
  # GET /authors/1.xml
  def show
    @author = Author.find(params[:id])
    respond_with(@author)
  end

  # GET /authors/new
  # GET /authors/new.xml
  def new
    @author = Author.new
    respond_with(@author)
  end

  # GET /authors/1/edit
  def edit
    @author = Author.find(params[:id])
  end

  # POST /authors
  # POST /authors.xml
  def create
    @author = Author.new(params[:author])
    @author.save
    respond_with(@author)
  end

  # PUT /authors/1
  # PUT /authors/1.xml
  def update
    @author = Author.find(params[:id])
    @author.update_attributes(params[:author])
    respond_with(@author)
  end

  # DELETE /authors/1
  # DELETE /authors/1.xml
  def destroy
    @author = Author.find(params[:id])
    @author.destroy
    respond_with(@author)
  end
end
