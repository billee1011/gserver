#!/bin/bash

DEBUG=false;
ACTION=start;

nohup java -Ddebug=$debug -jar AgentServer-0.0.1.jar $ACTION >/dev/null 2>&1 &
