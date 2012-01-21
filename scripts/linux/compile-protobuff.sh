#!/bin/bash

mkdir out >/dev/null 2>&1
echo "Google Protocol Buffer Compilation just began..."

for protofile in `dir -d *.proto` ; do
 echo "Compiling $protofile"
 protoc $protofile --java_out=out/
done

echo "Google Protocol Buffers Compiling DONE."
