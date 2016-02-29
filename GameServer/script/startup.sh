#!/bin/bash

DEBUG=false;
ACTION=start;

nohup java -Ddebug=$DEBUG -jar GameServer-project-version.jar $ACTION >/dev/null 2>&1 &
