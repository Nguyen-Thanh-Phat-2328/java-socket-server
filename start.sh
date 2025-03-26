#!/bin/sh
javac -d out -sourcepath src src/deploychatclientserver/DeployChatClientServer.java
java -cp out deploychatclientserver.DeployChatClientServer
