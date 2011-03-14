class ContactFormsController < ApplicationController
  
  # GET /contact_forms/new
  # GET /contact_forms/new.xml
  def new
    @contact_form = ContactForm.new
    respond_with(@contact_form)
  end

  # POST /contact_forms
  # POST /contact_forms.xml
  def create
    @contact_form = ContactForm.new(params[:contact_form])
    if @contact_form.deliver
		redirect_to root_path, :notice => "Thanks for your message"
	else 	
	   render "new"		
    end
  end
end
