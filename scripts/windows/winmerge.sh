#!/bin/sh

echo Launching WinMergeU.exe: $1 $2
"C:\Program Files (x86)\WinMerge"\WinMergeU.exe -e -ub -dl "Base" -dr "Mine" "$1" "$2"