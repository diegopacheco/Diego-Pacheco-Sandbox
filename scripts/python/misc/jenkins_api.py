import jenkinsapi
from jenkinsapi.jenkins import Jenkins

BASE_URL = 'host'
USERNAME = 'u'
PASS = 'p'

def connect():
	j = Jenkins(baseurl = BASE_URL, username = USERNAME, password = PASS)
	print "[Status Builds]"
	return j

def list_jobs():
	j = Jenkins(baseurl = BASE_URL, username = USERNAME, password = PASS)
	print "[Jobs]"
	print j.keys()

def get_status(j,project):
	job = j[project]
	build = job.get_last_build()
	status = build.get_status()
	print project + ": " + status

j = connect()
get_status(j,'j1')
get_status(j,'j2')