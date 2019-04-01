#!/usr/bin/env bash

# Must setup ssh key in server in order to run the script

source ./server.sh

# echo $build_number


ssh ubuntu@$server_ip 'rm ~/app/*.jar'
scp target/allianz-*.jar ubuntu@$server_ip:~/app
ssh ubuntu@$server_ip './stop-spring.sh'
ssh ubuntu@$server_ip 'nohup java -jar ~/app/*.jar &'
