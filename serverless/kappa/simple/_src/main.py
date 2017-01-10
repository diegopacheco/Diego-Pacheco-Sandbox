# -*- coding: utf-8 -*-
import logging
import requests
from simpleeggs.emath import *

LOG = logging.getLogger()
LOG.setLevel(logging.DEBUG)

def handler(event, context):
    assert context
    LOG.debug(event)
    r = requests.get('https://github.com/timeline.json')
    code = "http = " + str(r.status_code) + " sum =  " + str(sumEggs(2,2))
    return {'status': 'success - ' + str(code)  }
