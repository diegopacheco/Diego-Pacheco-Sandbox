import xmlrpclib

client = xmlrpclib.ServerProxy('http://localhost:8081')
print "WS Return == %s" % client.hello()
