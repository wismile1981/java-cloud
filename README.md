# Spring Cloud Microservices Project

This project is a microservices-based application built using Spring Cloud. It consists of multiple services that work together to provide user management, product management, and order processing capabilities.

## Architecture Overview

The project follows a microservices architecture with the following components:

- **Eureka Server**: Service discovery server
- **User Service**: Handles user management
- **Product Service**: Manages product information
- **Order Service**: Processes orders
- **API Gateway**: (Coming soon) Routes requests to appropriate services
- **Config Server**: (Coming soon) Centralizes configuration management

## Services and Ports

| Service | Port | Description |
|---------|------|-------------|
| Eureka Server | 8761 | Service discovery and registration |
| User Service | 8081 | User management and authentication |
| Product Service | 8082 | Product catalog and inventory |
| Order Service | 8083 | Order processing and management |

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher
- Git

## Database Setup

Create the following MySQL databases:

```sql
CREATE DATABASE user_service_db;
CREATE DATABASE product_service_db;
CREATE DATABASE order_service_db;
```

## Configuration

Each service has its own `application.yml` file in the `src/main/resources` directory. Update the database configurations if needed:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/[database_name]
    username: [your_username]
    password: [your_password]
```

## Building the Project

```bash
# Clone the repository
git clone [repository-url]

# Navigate to project directory
cd microservices-project

# Build all services
mvn clean install
```

## Running the Services

Start the services in the following order:

1. **Eureka Server**
```bash
cd eureka-server
mvn spring-boot:run
```

2. **User Service**
```bash
cd user-service
mvn spring-boot:run
```

3. **Product Service**
```bash
cd product-service
mvn spring-boot:run
```

4. **Order Service**
```bash
cd order-service
mvn spring-boot:run
```

## Service Dependencies

- **User Service**: Depends on Eureka Server
- **Product Service**: Depends on Eureka Server
- **Order Service**: Depends on Eureka Server, User Service, and Product Service

## API Documentation

### User Service
- POST `/api/users` - Create a new user
- GET `/api/users/{id}` - Get user by ID
- GET `/api/users` - Get all users

### Product Service
- POST `/api/products` - Create a new product
- GET `/api/products/{id}` - Get product by ID
- GET `/api/products` - Get all products
- PUT `/api/products/{id}` - Update product

### Order Service
- POST `/api/orders` - Create a new order
- GET `/api/orders/{id}` - Get order by ID
- GET `/api/orders` - Get all orders
- GET `/api/orders/user/{userId}` - Get orders by user ID

## Project Structure

```
microservices-project/
├── pom.xml
├── eureka-server/
│   ├── pom.xml
│   └── src/
├── user-service/
│   ├── pom.xml
│   └── src/
├── product-service/
│   ├── pom.xml
│   └── src/
└── order-service/
    ├── pom.xml
    └── src/
```

## Features

- Service Discovery using Netflix Eureka
- Database per Service
- RESTful APIs
- Inter-service Communication using FeignClient
- Centralized Configuration (Coming soon)
- API Gateway (Coming soon)
- Circuit Breaker (Coming soon)
- Distributed Tracing (Coming soon)

## Technology Stack

- **Spring Boot**: Application framework
- **Spring Cloud**: Microservices framework
- **Spring Data JPA**: Data persistence
- **MySQL**: Database
- **Maven**: Build tool
- **Netflix Eureka**: Service discovery
- **OpenFeign**: Service-to-service communication
- **Lombok**: Reduces boilerplate code

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Future Enhancements

- [ ] Implement API Gateway using Spring Cloud Gateway
- [ ] Add Config Server for centralized configuration
- [ ] Implement Circuit Breaker using Resilience4j
- [ ] Add distributed tracing with Spring Cloud Sleuth and Zipkin
- [ ] Implement authentication and authorization using OAuth2
- [ ] Add monitoring using Spring Boot Admin
- [ ] Implement caching using Redis
- [ ] Add message queuing using RabbitMQ or Kafka

## License

This project is licensed under the MIT License - see the LICENSE file for details
