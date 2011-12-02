require 'rubygems'
require 'ramaze'

class MainController < Ramaze::Controller
  def index
    'Hello, World! Ramaze :D'
  end
end

Ramaze.start