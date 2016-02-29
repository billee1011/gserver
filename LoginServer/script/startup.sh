#!/bin/bash

DEBUG=false;
ACTION=start;

nohup java -Ddebug=$DEBUG -jar LoginServer-project-version.jar $ACTION >/dev/null 2>&1 &
