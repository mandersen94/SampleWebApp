#!/bin/bash

#AGENT_JAR=
export BYTEMAN_HOME=/Users/mandersen/development/byteman/byteman-download-3.0.3

#java -cp ./target/classes org.markandersen.client.GoogleSearchMain
#java -javaagent:/Users/mandersen/development/projects/marks-java-agent/target/mark-java-agent-1.0-jar-with-dependencies.jar -cp ./target/classes org.markandersen.client.GoogleSearchMain


#java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:appmain.btm org.my.AppMain foo bar baz
java -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=boot:${BYTEMAN_HOME}/lib/byteman.jar,script:SocketMonitor2.btm -cp ./target/classes org.markandersen.client.GoogleSearchMain
