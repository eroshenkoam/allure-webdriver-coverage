#!/bin/bash

cp /app/executor.json /app/allure-results/executor.json
sh /opt/allure/allure-2.23.0/bin/allure serve -h 0.0.0.0 -p 8080 /app/allure-results
