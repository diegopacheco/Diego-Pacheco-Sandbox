import os
f = os.popen('hostname -i')
r = f.read()
print "Host: ", r
