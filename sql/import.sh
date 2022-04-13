#!/bin/bash

cat mysql-camel-init.sql | docker-compose exec -T mysql mysql -uroot -proot