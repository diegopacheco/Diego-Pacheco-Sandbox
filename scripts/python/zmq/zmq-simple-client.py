HOST = "127.0.0.1"
PORT = "22300"

import zmq
context = zmq.Context()
s = context.socket(zmq.SUB)
p = "tcp://"+ HOST +":"+ PORT
s.connect(p)
s.setsockopt(zmq.SUBSCRIBE, "TIME")

for i in range(5):
    time = s.recv()
    print time
