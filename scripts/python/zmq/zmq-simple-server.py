import zmq, time

HOST = "127.0.0.1"
PORT = "22300"

context = zmq.Context()
s = context.socket(zmq.PUB)
p = "tcp://"+ HOST +":"+ PORT
s.bind(p)
while True:
    time.sleep(5)
    s.send("TIME " + time.asctime())
