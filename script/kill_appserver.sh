#!/bin/sh

ps -opid,command | grep DevAppServerMain | grep -v grep | grep ' -ea ' | cut -f2 -d' ' | xargs kill
