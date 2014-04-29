import cyclone.web
import sys

from twisted.internet import reactor
from twisted.python import log


class MainHandler(cyclone.web.RequestHandler):
    def get(self):
        self.write("Hello, world")


if __name__ == "__main__":
    application = cyclone.web.Application([
        (r"/", MainHandler)
    ])

    log.startLogging(sys.stdout)
    reactor.listenTCP(8888, application, interface="10.99.2.151")
    reactor.run()