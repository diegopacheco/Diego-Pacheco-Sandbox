#!/bin/bash
ansible all -m ping -iansible_hosts --private-key zerotocloud.pem
