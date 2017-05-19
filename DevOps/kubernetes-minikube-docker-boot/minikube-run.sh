#!/bin/bash

minikube start

kubectl run boot --image=diegopacheco/boot:latest --port=8080

kubectl expose deployment boot --type=NodePort

kubectl get pod

curl $(minikube service boot --url)
