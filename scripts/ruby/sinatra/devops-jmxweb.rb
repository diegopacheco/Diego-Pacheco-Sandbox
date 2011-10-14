require 'rubygems'
require 'sinatra'

get '/' do
  File.open('jmxweb.out').read.gsub("\n", "<br/>")
end