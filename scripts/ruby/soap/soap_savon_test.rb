require 'rubygems'
require 'savon'

client = Savon::Client.new do
  wsdl.document = "http://www.webservicex.net/periodictable.asmx?WSDL"
end

puts client.wsdl.soap_actions

response = client.request :wsdl, "get_element_symbol" do
	soap.body = {
	  :ElementName => "Zinc"
    }
end

#puts client.request("get_atoms").to_hash