#!/bin/bash

javac -d build -cp lib/*:src src/*/*.java

java -cp build vue.Main
