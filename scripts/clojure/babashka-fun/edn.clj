#!/bin/bash

bb '(vec (dedupe *input*))' <<< '[1 1 1 1 2]'
