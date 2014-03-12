import httplib2
import urllib

URL = "http://www.google.com"

def getStatus():
	body = {}
	headers = {}

	http = httplib2.Http()
	response, content = http.request(URL , 'GET', headers=headers, body=urllib.urlencode(body))
	print response	

getStatus()