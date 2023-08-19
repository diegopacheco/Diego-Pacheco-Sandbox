#!/bin/bash

people=diegopacheco
for p in $people
do 
  count=$(curl -s "https://github.com/users/$p/contributions" |  grep -B2 last | sed 's/[^0-9]*//g' | sed -r 's/\s+//g' | tr --delete '\n');
  echo "[$p] GitHub Last Year Contributions: [$count]";
done