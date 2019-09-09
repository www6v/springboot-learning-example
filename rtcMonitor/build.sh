#!/bin/bash

mvn clean

git pull origin master

mvn package -P pre
