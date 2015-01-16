#! /bin/bash

find . -name .svn -type d | xargs rm -rf
find . -name target -type d | xargs rm -rf