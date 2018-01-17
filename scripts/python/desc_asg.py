import boto3
import os

client = boto3.client('autoscaling',
    aws_access_key_id=os.environ['AAK'],
    aws_secret_access_key=os.environ['ASK'],
    region_name='us-west-2')

response = client.describe_auto_scaling_groups(
    AutoScalingGroupNames=[
        'shutdondmcl-dm-perf-us-west-2a-v0',
    ],
    MaxRecords=100
)

lcName = response["AutoScalingGroups"][0]["LaunchConfigurationName"]
print "LC name: " + lcName
print "Discovering all LCs"
print ""

def getVersions(lcName):
    try:
        lcName = lcName[len(lcName) - lcName[::-1].index("v"):len(lcName)]
        return lcName
    except:
        return 0

pureName = lcName[0:len(lcName) - lcName[::-1].index("v")-1] + "v"
for i in range(0, int(getVersions(lcName))+1):
    try:
        print "Checking LC: " + pureName+str(i)
        response = client.describe_launch_configurations(
            LaunchConfigurationNames=[
                pureName+str(i),
            ],
            MaxRecords=1
        )
        print "Found LC[" + str(i) + "] " + response["LaunchConfigurations"][0]["LaunchConfigurationName"]
    except Exception as e:
        print "Not Found"
