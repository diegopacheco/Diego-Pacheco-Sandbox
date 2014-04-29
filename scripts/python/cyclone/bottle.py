import sys
from cyclone.bottle import run, route


@route("/")
def index(web):
    web.write("Hello, world")

run(host="localhost", port=8888, log=sys.stdout)