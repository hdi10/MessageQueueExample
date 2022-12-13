#!/bin/bash

javac -cp amqp-client-5.7.1.jar Consumer.java Producer.javaj

java -cp .:amqp-client-5.7.1.jar:slf4j-api-1.7.26.jar:slf4j-simple-1.7.26.jar Consumer

java -cp .:amqp-client-5.7.1.jar:slf4j-api-1.7.26.jar:slf4j-simple-1.7.26.jar Producer


javac -cp amqp-client-5.7.1.jar NewTask.java Worker.java
