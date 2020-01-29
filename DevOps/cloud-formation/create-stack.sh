#!/bin/bash

aws cloudformation create-stack --stack-name ec2 --region us-west-2 --template-body file://ec2.yml

# aws cloudformation create-stack --stack-name ec2 --region us-west-2 --template-body https://s3-us-west-2.amazonaws.com/cloudformation-templates-us-west-2/EC2InstanceWithSecurityGroupSample.template --parameters "ParameterKey=KeyName,ParameterValue=name"