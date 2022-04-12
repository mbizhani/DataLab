#!/bin/bash

cat mysql-camel-init.sql | docker-compose -T mysql mysql -uroot -proot