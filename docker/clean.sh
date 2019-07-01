#!/bin/bash

docker stop frontend1
docker rm frontend1
docker stop frontend2
docker rm frontend2
docker stop jboss1
docker rm jboss1
docker stop jboss2
docker rm jboss2
docker stop postgres
docker rm postgres
docker stop lbas
docker rm lbas
docker stop lbws
docker rm lbws