#!/bin/bash

docker run -dit --name frontend1 --network trustpet_network --ip 172.19.0.2 -p 8081:80 -v /Users/bernardo/EA/Projeto/trustpet/docker/frontend/frontend:/usr/local/apache2/htdocs/ myhttpd
docker run -dit --name frontend2 --network trustpet_network --ip 172.19.0.3 -p 8082:80 -v /Users/bernardo/EA/Projeto/trustpet/docker/frontend/frontend:/usr/local/apache2/htdocs/ myhttpd
docker run -dit --name jboss1 --network trustpet_network --ip 172.19.0.4 -p 8083:8080 myjboss
docker run -dit --name jboss2 --network trustpet_network --ip 172.19.0.5 -p 8084:8080 myjboss
docker run -dit --name postgres --network trustpet_network --ip 172.19.0.6 -p 5432:5432 mypostgres
docker run -dit --name lbws --network trustpet_network --ip 172.19.0.7 -p 80:80 myhaproxyws
docker run -dit --name lbas --network trustpet_network --ip 172.19.0.8 -p 8080:80 myhaproxyas