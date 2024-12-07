#!/bin/bash

# Function to start a service
start_service() {
    local service=$1
    echo "Starting $service..."
    cd $service
    mvn spring-boot:run &
    cd ..
    sleep 10  # Wait for service to start
}

# Start Eureka Server first
echo "Starting Eureka Server..."
start_service eureka-server

# Wait for Eureka Server to be fully up
echo "Waiting for Eureka Server to start..."
sleep 20

# Start other services
start_service user-service
start_service product-service
start_service order-service

echo "All services are starting..."
echo "Eureka Server: http://localhost:8761"
echo "Use 'jps' command to see all running Java processes"
echo "Use 'kill <pid>' to stop a specific service"
