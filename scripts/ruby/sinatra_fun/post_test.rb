require "net/http"
require "uri"

uri = URI.parse("http://www.google.com/search?q=ruby")
response = Net::HTTP.get_response(uri)
Net::HTTP.get_print(uri)