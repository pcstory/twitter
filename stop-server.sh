#!/usr/bin/env bash

# Must setup ssh key in server in order to run the script

source ./server.sh

# echo $build_number


ssh ubuntu@$server_ip './stop-spring.sh'
