#!/bin/bash

docker build -t myhttpd frontend
docker build -t myjboss jboss
docker build -t mypostgres postgres
docker build -t myhaproxyws lbWS
docker build -t myhaproxyas lbAS