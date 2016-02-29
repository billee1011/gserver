#!/bin/bash

DEBUG=false;
ACTION=start;

nohup java -Ddebug=$DEBUG -jar AgentServer-project-version.jar $ACTION >/dev/null 2>&1 &
