require 'rubygems'
require 'eventmachine'
require 'evma_httpserver'

class HttpServer < EM::Connection
  include EM::HttpServer
  def process_http_request
    response = EM::DelegatedHttpResponse.new(self)
    response.status = 200
    response.content_type 'text/html'
    response.content = '<center><h1>Event Machine Rocks</h1></center>'
    response.send_response
  end
end

EM.run do
  EM.start_server '0.0.0.0', 8080, HttpServer
end

