# coding: utf-8
# twisted application: foobar.tac

import cyclone.web
from twisted.application import service, internet

class IndexHandler(cyclone.web.RequestHandler):
	def get(self):
		self.write("hello world")

foobar = cyclone.web.Application([(r"/", IndexHandler)])

application = service.Application("foobar")
internet.TCPServer(8080, foobar, interface="127.0.0.1").setServiceParent(application)