import redis
import time

#
# Simple Dyno implementation in Python.
# Right now just retry/fallback is supported.
#
# @author diegopacheco
# @version 1.0
# @since 26/05/2017
#
class DynoPythonDriver:

    def __init__(self,seeds):
        self.redisPort = 6379
        self.MAX_RETRY  = 3
        self.seeds = seeds.split('|')
        self.cnn   = self.connectRedis()
        self.retryCount = 0

    def connectRedis(self):
        return redis.StrictRedis(host=self.seeds[0], port=self.redisPort)

    def runWithFallback(self,callback):
        while(True):
            try:
                print "try slot: " + str(self.retryCount)
                result = callback(self.cnn)
                return result
            except redis.exceptions.ConnectionError as ce:
                print "Connection Error. "
                self.retryCount = self.retryCount + 1
            except Exception as e:
                print "Error: "
                self.retryCount = self.retryCount + 1
            if (self.retryCount<=self.MAX_RETRY):
                self.seeds.pop
                time.sleep(1)
                print "Retry... "
                self.cnn  = self.connectRedis()
            else:
                raise Exception("MAX number of retry exceded! ")

def simpleCode(r):
    result = r.get('foo')
    print result

def main():
    driver = DynoPythonDriver('127.0.0.1|127.0.0.1|127.0.0.1')
    while(True):
        try:
            driver.runWithFallback(simpleCode)
            time.sleep(1)
        except Exception as e:
            print "Abording program... Error: " + str(e)
            break

main()
