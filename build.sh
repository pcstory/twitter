#!/usr/bin/env bash

build_number=$(date +"%m%d%y"-"%H%M")

echo 'New Build ' $build_number
mvn versions:set -DnewVersion=0.0.1-SNAPSHOT-$build_number
mvn clean package
