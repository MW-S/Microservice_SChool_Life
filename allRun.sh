#!/bin/bash
# Author: M&W
alias podman=docker
#运行配置组件
echo "Start Eureka"
sh run.sh eureka 8000 172.17.0.1 &
echo "Start Config"
sh run.sh config 8005 172.17.0.1 &
echo "Start Gateway"
sh run.sh gateway 8080 172.17.0.1 &

#运行微服务组件
echo "Start User"
sh run_provider.sh user 8081 172.17.0.1 &
echo "Start Entertainment"
sh run_provider.sh entertainment 8082 172.17.0.1 &
echo "Start Diet"
sh run_provider.sh diet 8083 172.17.0.1 &
#sh run_provider.sh place 8084 172.17.0.1 &
#sh run_provider.sh traffic 8085 172.17.0.1 &
#sh run_provider.sh goods 8086 172.17.0.1 &

echo "Finished ~"