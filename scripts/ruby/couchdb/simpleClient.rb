require 'net/http'
require 'couchdb/couchplay'

server = Couch::Server.new("localhost", "5984")

doc = <<-JSON
{"type":"comment","body":"First Post!"}
JSON
#server.put("/foo/document_id", doc)

res = server.get("/foo/document_id")
json = res.body
puts json