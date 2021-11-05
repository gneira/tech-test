#!/bin/bash 

if [ "$1" != "" ]; then
  PORT=--server.port=$1
fi

nohup java -Xmx512m -Xss2m -Xms128M -jar technical-test-0.0.1-SNAPSHOT.jar --spring.config.name=application $PORT > output.log 2>&1&
echo $! > pid
