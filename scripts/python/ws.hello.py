import SimpleXMLRPCServer

def hello():
    return "Hello World Python WS"
	
server = SimpleXMLRPCServer.SimpleXMLRPCServer(('localhost',8081))
server.register_function(hello)

print "Webservice up and running in python... "
server.serve_forever()