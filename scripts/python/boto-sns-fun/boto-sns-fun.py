import boto3

client = boto3.client('sns')

TOPIC  = 'arn:aws:sns:us-west-2:<CHANGE_HERE>'

MSG    = """{
"default": "TEST",
"lambda": "TEST",
"http": "TEST",
"APNS_VOIP_SANDBOX": "{\"aps\":{\"alert\": \"TEST\"} }",
"WNS" : "<badge version\"1\" value\"23\"/>"
}"""

pub = client.publish(TopicArn = TOPIC, Message = MSG )
print "DONE. Client: " + str(client) + " ,Pub: " + str(pub)
