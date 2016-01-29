#!/bin/sh
javac -classpath ~/lib/sootclasses-2.3.0.jar:~/lib/jasminclasses-2.3.0.jar:~/lib/polyglotclasses-1.3.5.jar -d ./bin `find ./src -name "*java"`
