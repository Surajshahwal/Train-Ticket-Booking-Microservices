# 🚂 Train Ticket Booking System - Microservices Architecture

A production-ready microservices application built with Spring Boot, demonstrating enterprise-level features including inter-service communication, database persistence, pagination, structured API responses, and comprehensive logging.

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Architecture](#-architecture)
- [Technologies Used](#-technologies-used)
- [Key Features](#-key-features)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [API Endpoints](#-api-endpoints)
- [API Response Structure](#-api-response-structure)
- [Testing](#-testing)
- [Project Structure](#-project-structure)
- [Development Environment](#-development-environment)
- [Learning Outcomes](#-learning-outcomes)
- [Screenshots](#-screenshots)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)
- [License](#-license)

---

## 🎯 Overview

This project implements a **microservices architecture** simulating real-world train ticket booking systems like **IRCTC** and **MakeMyTrip**. It demonstrates professional backend development practices with enterprise-level features.

### What This Project Demonstrates

- **Provider-Consumer Pattern**: Separation of concerns with independent microservices
- **Inter-service Communication**: WebClient for asynchronous HTTP calls between services
- **Enterprise Features**: Logging, pagination, standardized API responses, exception handling
- **Database Persistence**: MySQL with JPA/Hibernate ORM for data management
- **Professional API Design**: RESTful principles with consistent response formats
- **Scalable Architecture**: Microservices foundation for horizontal scaling

---

## 🏗️ Architecture
```
┌─────────────────┐
│     Client      │
│   (Postman/UI)  │
└────────┬────────┘
         │ HTTP Request
         ▼
┌────────────────────────────────────┐
│   Consumer Service (Port 8081)    │
│    MakeMyTrip REST API             │
│  ┌──────────────────────────────┐ │
│  │  • WebClient Integration     │ │
│  │  • Exception Handling        │ │
│  │  • API Response Wrapper      │ │
│  │  • Logging (SLF4J)          │ │
│  └──────────────────────────────┘ │
└────────┬───────────────────────────┘
         │ WebClient HTTP Call
         ▼
┌────────────────────────────────────┐
│   Provider Service (Port 8080)    │
│      IRCTC REST API                │
│  ┌──────────────────────────────┐ │
│  │  • Database Operations       │ │
│  │  • Business Logic            │ │
│  │  • Validation                │ │
│  │  • Pagination                │ │
│  │  • Logging (SLF4J)          │ │
│  │  • Swagger Documentation     │ │
│  └──────────────────────────────┘ │
└────────┬───────────────────────────┘
         │ JPA/Hibernate
         ▼
    ┌─────────────┐
    │    MySQL    │
    │  Database   │
    └─────────────┘
```

### Architecture Highlights

- **Separation of Concerns**: Provider handles business logic, Consumer handles client requests
- **Loose Coupling**: Services communicate via REST APIs, can be deployed independently
- **Scalability**: Each service can scale horizontally based on load
- **Resilience**: Consumer handles Provider failures gracefully with exception handling

---

## 🛠️ Technologies Used

### Provider Service (IRCTC - Backend)

| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 3.2.0 | Application Framework |
| **Spring Data JPA** | 3.2.0 | Database Access Layer |
| **Hibernate ORM** | 6.x | Object-Relational Mapping |
| **MySQL** | 8.0+ | Relational Database |
| **Bean Validation** | 3.0 | Input Validation |
| **SLF4J + Logback** | 2.0 | Logging Framework |
| **Swagger/OpenAPI** | 3.0 | API Documentation |
| **Maven** | 3.6+ | Build & Dependency Management |

### Consumer Service (MakeMyTrip - Client)

| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 3.2.0 | Application Framework |
| **Spring WebFlux** | 3.2.0 | Reactive Web (WebClient) |
| **SLF4J + Logback** | 2.0 | Logging Framework |
| **Maven** | 3.6+ | Build & Dependency Management |

### Common Technologies

- **Java** 17 (LTS)
- **Spring Core** - Dependency Injection, IoC Container
- **Jackson** - JSON Serialization/Deserialization
- **Tomcat** - Embedded Web Server

---

## ✨ Key Features

### Core Functionality

- ✅ **Ticket Booking** - Create new train ticket bookings with passenger details
- ✅ **Ticket Retrieval** - Get ticket information by unique ticket ID
- ✅ **Ticket Cancellation** - Cancel existing bookings
- ✅ **List All Tickets** - Retrieve all bookings with pagination support

### Enterprise Features

- ✅ **Microservices Architecture** - Provider-Consumer pattern implementation
- ✅ **Database Persistence** - MySQL with JPA/Hibernate for data storage
- ✅ **Global Exception Handling** - Custom exceptions with proper HTTP status codes
- ✅ **Bean Validation** - Input validation with JSR-380 annotations
- ✅ **Inter-service Communication** - WebClient for async HTTP calls
- ✅ **Standardized API Responses** - ApiResponse wrapper for consistent response structure
- ✅ **Pagination Support** - Spring Data Pagination for efficient data retrieval
- ✅ **Comprehensive Logging** - SLF4J logging for request/response tracking
- ✅ **API Documentation** - Swagger/OpenAPI for interactive API testing
- ✅ **Exception Propagation** - Consumer handles Provider errors gracefully
- ✅ **Layered Architecture** - Controller-Service-Repository pattern
- ✅ **RESTful Design** - Proper HTTP methods and status codes

---

## 📋 Prerequisites

Before running this project, ensure you have:

### Required Software

- ☑️ **Java 17** or higher ([Download](https://www.oracle.com/java/technologies/downloads/))
- ☑️ **MySQL 8.0** or higher ([Download](https://dev.mysql.com/downloads/))
- ☑️ **Maven 3.6+** (included in STS/IDE)

### Development Tools

- ☑️ **Spring Tool Suite (STS) 4.x** (Recommended) / Eclipse / IntelliJ IDEA
- ☑️ **MySQL Workbench** (for database management)
- ☑️ **Postman** (optional, for API testing)
- ☑️ **Git** (for version control)

### Recommended IDE

**Spring Tool Suite (STS)** - Best for Spring Boot development with built-in Spring Boot Dashboard and Maven integration

---

## 🚀 Installation & Setup

### Step 1: Clone Repository
```bash
git clone https://github.com/Surajshahwal/Train-Ticket-Booking-Microservices.git
cd Train-Ticket-Booking-Microservices
```

### Step 2: Database Setup

Open **MySQL Workbench** and create database:
```sql
CREATE DATABASE train_booking;
```

Verify:
```sql
SHOW DATABASES;
USE train_booking;
```

### Step 3: Configure Provider Service

Navigate to `IRCTC_Provider/src/main/resources/application.properties` and update:
```properties
# Database Configuration - UPDATE YOUR PASSWORD
spring.datasource.url=jdbc:mysql://localhost:3306/train_booking
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### Step 4: Import Projects in IDE

#### Using Spring Tool Suite (STS) / Eclipse:

1. Open **Spring Tool Suite (STS)**
2. File → Import → Maven → **Existing Maven Projects**
3. Browse to `IRCTC_Provider` folder → Select `pom.xml` → Finish
4. Repeat for `MakeMyTrip_Consumer` folder
5. Wait for Maven dependencies to download

#### Using IntelliJ IDEA:

1. Open **IntelliJ IDEA**
2. File → Open → Select project root folder
3. IntelliJ will auto-detect Maven projects
4. Wait for indexing and dependency resolution

### Step 5: Run Provider Service (Port 8080)

#### In STS/Eclipse:
1. Navigate to `src/main/java/in/train/IrctcProviderApplication.java`
2. Right-click → **Run As** → **Spring Boot App**
3. Wait for console message: `Started IrctcProviderApplication in X seconds`

#### Via Command Line:
```bash
cd IRCTC_Provider
mvn clean install
mvn spring-boot:run
```

✅ **Provider Service running on:** `http://localhost:8080`

### Step 6: Run Consumer Service (Port 8081)

#### In STS/Eclipse:
1. Navigate to `src/main/java/in/train/MakeMyTripConsumerApplication.java`
2. Right-click → **Run As** → **Spring Boot App**
3. Wait for console message: `Started MakeMyTripConsumerApplication in X seconds`

#### Via Command Line:
```bash
cd MakeMyTrip_Consumer
mvn clean install
mvn spring-boot:run
```

✅ **Consumer Service running on:** `http://localhost:8081`

### Step 7: Verify Setup

1. **Provider Health Check:**
```
   http://localhost:8080/api/tickets
```
   Should return empty list or paginated response

2. **Consumer Health Check:**
```
   http://localhost:8081/api/makemytrip/book
```
   Should accept POST requests

3. **Swagger UI:**
```
   http://localhost:8080/swagger-ui.html
```
   Should display interactive API documentation

---

## 📡 API Endpoints

### Provider Service (IRCTC) - `http://localhost:8080`

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `POST` | `/api/tickets` | Book a new ticket | Passenger JSON | ApiResponse<Ticket> |
| `GET` | `/api/tickets/{id}` | Get ticket by ID | - | ApiResponse<Ticket> |
| `DELETE` | `/api/tickets/{id}` | Cancel ticket by ID | - | ApiResponse<String> |
| `GET` | `/api/tickets` | Get all tickets | Query params: page, size | ApiResponse<Page<Ticket>> |

**Pagination Parameters:**
- `page` - Page number (default: 0)
- `size` - Page size (default: 10)

**Example:** `GET /api/tickets?page=0&size=10`

### Consumer Service (MakeMyTrip) - `http://localhost:8081`

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `POST` | `/api/makemytrip/book` | Book ticket via IRCTC | Passenger JSON | ApiResponse<Ticket> |
| `GET` | `/api/makemytrip/ticket/{id}` | Get ticket details | - | ApiResponse<Ticket> |
| `DELETE` | `/api/makemytrip/cancel/{id}` | Cancel ticket | - | ApiResponse<String> |

### Swagger Documentation

Interactive API documentation available at:
```
http://localhost:8080/swagger-ui.html
```

Features:
- Try out APIs directly from browser
- View request/response schemas
- See all available endpoints
- Test with sample data

---

## 📦 API Response Structure

All API responses follow a **standardized format** using `ApiResponse<T>` wrapper class for consistency.

### Success Response Format
```json
{
    "success": true,
    "message": "Ticket booked successfully",
    "data": {
        "ticketId": 1,
        "passengerName": "Suraj Shah",
        "from": "Bhopal",
        "to": "Delhi",
        "trainNum": "12345",
        "tktCost": "500.0 INR",
        "ticketStatus": "CONFIRMED",
        "pnr": "1234567890",
        "bookingTime": "2026-02-05T12:00:00"
    },
    "timestamp": "2026-02-05T12:00:00.123456"
}
```

### Error Response Format
```json
{
    "success": false,
    "message": "Ticket not found with ID: 999",
    "data": null,
    "timestamp": "2026-02-05T12:00:00.123456"
}
```

### Paginated Response Format
```json
{
    "success": true,
    "message": "Tickets retrieved successfully",
    "data": {
        "content": [
            {
                "ticketId": 1,
                "passengerName": "Suraj Shah",
                "from": "Bhopal",
                "to": "Delhi",
                "trainNum": "12345",
                "tktCost": "500.0 INR",
                "ticketStatus": "CONFIRMED",
                "pnr": "1234567890",
                "bookingTime": "2026-02-05T12:00:00"
            }
        ],
        "pageable": {
            "pageNumber": 0,
            "pageSize": 10
        },
        "totalElements": 50,
        "totalPages": 5,
        "size": 10,
        "number": 0,
        "first": true,
        "last": false
    },
    "timestamp": "2026-02-05T12:00:00.123456"
}
```

### Validation Error Response
```json
{
    "success": false,
    "message": "Validation Failed",
    "data": {
        "validationErrors": {
            "fname": "First name is required",
            "trainNum": "Train number must be 5 digits"
        }
    },
    "timestamp": "2026-02-05T12:00:00.123456"
}
```

---

## 🧪 Testing

### Test 1: Book Ticket (via Consumer)

**Request:**
```bash
POST http://localhost:8081/api/makemytrip/book
Content-Type: application/json

{
    "fname": "Suraj",
    "lname": "Shah",
    "gender": "Male",
    "from": "Bhopal",
    "to": "Delhi",
    "doj": "2026-03-15",
    "trainNum": "12345"
}
```

**Expected Response (200 Created):**
```json
{
    "success": true,
    "message": "Ticket booked successfully",
    "data": {
        "ticketId": 1,
        "passengerName": "Suraj Shah",
        "from": "Bhopal",
        "to": "Delhi",
        "trainNum": "12345",
        "tktCost": "500.0 INR",
        "ticketStatus": "CONFIRMED",
        "pnr": "1234567890",
        "bookingTime": "2026-02-05T12:00:00"
    },
    "timestamp": "2026-02-05T12:00:00"
}
```

### Test 2: Get Ticket by ID

**Request:**
```bash
GET http://localhost:8081/api/makemytrip/ticket/1
```

**Expected Response (200 OK):**
```json
{
    "success": true,
    "message": "Ticket retrieved successfully",
    "data": {
        "ticketId": 1,
        "passengerName": "Suraj Shah",
        "from": "Bhopal",
        "to": "Delhi",
        "trainNum": "12345",
        "tktCost": "500.0 INR",
        "ticketStatus": "CONFIRMED",
        "pnr": "1234567890"
    },
    "timestamp": "2026-02-05T12:00:00"
}
```

### Test 3: Get All Tickets with Pagination

**Request:**
```bash
GET http://localhost:8080/api/tickets?page=0&size=10
```

**Expected Response (200 OK):**
```json
{
    "success": true,
    "message": "Tickets retrieved successfully",
    "data": {
        "content": [...],
        "totalElements": 50,
        "totalPages": 5,
        "size": 10,
        "number": 0
    },
    "timestamp": "2026-02-05T12:00:00"
}
```

### Test 4: Cancel Ticket

**Request:**
```bash
DELETE http://localhost:8081/api/makemytrip/cancel/1
```

**Expected Response (200 OK):**
```json
{
    "success": true,
    "message": "Ticket cancelled successfully",
    "data": "Ticket cancelled successfully",
    "timestamp": "2026-02-05T12:00:00"
}
```

### Test 5: Error Scenario - Invalid Ticket ID

**Request:**
```bash
GET http://localhost:8081/api/makemytrip/ticket/999
```

**Expected Response (404 Not Found):**
```json
{
    "success": false,
    "message": "Ticket not found with ID: 999",
    "data": null,
    "timestamp": "2026-02-05T12:00:00"
}
```

### Test 6: Validation Error

**Request:**
```bash
POST http://localhost:8081/api/makemytrip/book
Content-Type: application/json

{
    "fname": "",
    "lname": "Shah"
}
```

**Expected Response (400 Bad Request):**
```json
{
    "success": false,
    "message": "Validation Failed",
    "data": {
        "validationErrors": {
            "fname": "First name is required",
            "gender": "Gender is required",
            "from": "Source station is required",
            "to": "Destination station is required",
            "doj": "Date of journey is required",
            "trainNum": "Train number is required"
        }
    },
    "timestamp": "2026-02-05T12:00:00"
}
```

---

## 📂 Project Structure
```
Train-Ticket-Booking-Microservices/
│
├── IRCTC_Provider/                         # Provider Microservice (Backend)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/in/train/
│   │   │   │   ├── IrctcProviderApplication.java      # Main Application Class
│   │   │   │   ├── entity/                            # JPA Entity Classes
│   │   │   │   │   └── TicketEntity.java             # Database Entity
│   │   │   │   ├── repository/                        # Spring Data JPA Repositories
│   │   │   │   │   └── TicketRepository.java         # Data Access Layer
│   │   │   │   ├── service/                           # Business Logic Layer
│   │   │   │   │   └── TicketService.java            # Service Implementation
│   │   │   │   ├── controller/                        # REST Controllers
│   │   │   │   │   └── TicketController.java         # API Endpoints
│   │   │   │   ├── exception/                         # Exception Handling
│   │   │   │   │   ├── TicketNotFoundException.java  # Custom Exception
│   │   │   │   │   └── GlobalExceptionHandler.java   # @RestControllerAdvice
│   │   │   │   ├── request/                           # Request DTOs
│   │   │   │   │   └── Passenger.java                # Input Data Transfer Object
│   │   │   │   ├── response/                          # Response DTOs
│   │   │   │   │   └── Ticket.java                   # Output Data Transfer Object
│   │   │   │   ├── api/                               # API Response Wrapper
│   │   │   │   │   └── ApiResponse.java              # Standardized Response
│   │   │   │   └── config/                            # Configuration Classes
│   │   │   │       └── SwaggerConfig.java            # Swagger/OpenAPI Config
│   │   │   └── resources/
│   │   │       ├── application.properties             # Application Configuration
│   │   │       └── logback.xml                        # Logging Configuration
│   │   └── test/                                      # Unit & Integration Tests
│   ├── target/                                        # Compiled Classes (ignored)
│   └── pom.xml                                        # Maven Dependencies
│
├── MakeMyTrip_Consumer/                    # Consumer Microservice (Client)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/in/train/
│   │   │   │   ├── MakeMyTripConsumerApplication.java # Main Application Class
│   │   │   │   ├── service/                           # WebClient Service Layer
│   │   │   │   │   └── MakeMyTripService.java        # Provider Communication
│   │   │   │   ├── controller/                        # REST Controllers
│   │   │   │   │   └── MakeMyTripController.java     # API Endpoints
│   │   │   │   ├── exception/                         # Exception Handling
│   │   │   │   │   ├── TicketNotFoundException.java  # Custom Exception
│   │   │   │   │   └── GlobalExceptionHandler.java   # Error Handler
│   │   │   │   ├── request/                           # Request DTOs
│   │   │   │   │   └── Passenger.java                # Input DTO
│   │   │   │   ├── response/                          # Response DTOs
│   │   │   │   │   └── Ticket.java                   # Output DTO
│   │   │   │   ├── api/                               # API Response Wrapper
│   │   │   │   │   └── ApiResponse.java              # Standardized Response
│   │   │   │   └── config/                            # Configuration Classes
│   │   │   │       └── WebClientConfig.java          # WebClient Bean Config
│   │   │   └── resources/
│   │   │       ├── application.properties             # Application Configuration
│   │   │       └── logback.xml                        # Logging Configuration
│   │   └── test/                                      # Unit & Integration Tests
│   ├── target/                                        # Compiled Classes (ignored)
│   └── pom.xml                                        # Maven Dependencies
│
├── screenshots/                            # Project Screenshots (optional)
│   ├── swagger-ui.png
│   ├── postman-success.png
│   ├── pagination.png
│   └── mysql-data.png
│
├── .gitignore                              # Git Ignore File
├── README.md                               # Project Documentation
└── LICENSE                                 # License File (optional)
```

---

## 🔧 Development Environment

### IDE Used

This project was developed using:

- **Primary IDE:** Spring Tool Suite (STS) 4.x
- **Build Tool:** Apache Maven 3.6+
- **Database Tool:** MySQL Workbench 8.0
- **API Testing:** Postman
- **Version Control:** Git

### Why Spring Tool Suite (STS)?

- ✅ Built specifically for Spring Boot development
- ✅ Integrated Spring Boot Dashboard for easy service management
- ✅ Maven integration out-of-the-box
- ✅ Built-in Git support
- ✅ Auto-completion for Spring annotations
- ✅ Embedded server management (Tomcat)

### Alternative IDEs

**Eclipse:**
- Install Spring Tools plugin from Eclipse Marketplace
- Similar features to STS

**IntelliJ IDEA:**
- Community Edition: Free with Spring Boot support
- Ultimate Edition: Advanced Spring features

**VS Code:**
- Install Spring Boot Extension Pack
- Lightweight alternative

---

## 🎓 Learning Outcomes

This project demonstrates proficiency in:

### Architecture & Design
- ✅ **Microservices Architecture** - Provider-Consumer pattern implementation
- ✅ **RESTful API Design** - HTTP methods, status codes, resource naming
- ✅ **Layered Architecture** - Separation of concerns (Controller-Service-Repository)
- ✅ **Dependency Injection** - Spring IoC container and @Autowired

### Backend Development
- ✅ **Spring Boot Ecosystem** - Core, Data JPA, WebFlux, Validation
- ✅ **Database Management** - MySQL with JPA/Hibernate ORM
- ✅ **ORM Concepts** - Entity mapping, relationships, transactions
- ✅ **Query Methods** - Spring Data JPA repository pattern

### Advanced Features
- ✅ **Inter-service Communication** - WebClient for async HTTP calls
- ✅ **Exception Handling** - Global exception handling with @RestControllerAdvice
- ✅ **Input Validation** - Bean Validation (JSR-380)
- ✅ **Pagination** - Spring Data Pagination for large datasets
- ✅ **Logging** - SLF4J with Logback for application monitoring
- ✅ **API Response Standardization** - Consistent response wrapper pattern

### Professional Practices
- ✅ **Code Organization** - Package structure, naming conventions
- ✅ **API Documentation** - Swagger/OpenAPI integration
- ✅ **Error Handling** - Proper HTTP status codes and error messages
- ✅ **Build Management** - Maven for dependency management
- ✅ **Version Control** - Git for source code management

---

## 📸 Screenshots

### 1. Swagger UI - API Documentation
![Swagger UI](screenshots/swagger-ui.png)
*Interactive API documentation with try-it-out functionality*

### 2. Postman - Successful Booking
![Postman Success](screenshots/postman-success.png)
*Ticket booking via Consumer service with standardized response*

### 3. Database - MySQL Workbench
![MySQL Database](screenshots/mysql-data.png)
*Persistent data storage in tickets table*

### 4. Pagination Response
![Pagination](screenshots/pagination.png)
*Paginated ticket retrieval with metadata*

### 5. Spring Tool Suite - Workspace
![STS Workspace](screenshots/sts-workspace.png)
*Development environment with both microservices*

---

## 🚀 Future Enhancements

Potential improvements for production deployment:

### Security
- [ ] **JWT Authentication** - Token-based authentication
- [ ] **Spring Security** - Role-based access control (RBAC)
- [ ] **OAuth2** - Third-party authentication integration

### Performance
- [ ] **Redis Caching** - Cache frequently accessed data
- [ ] **Database Indexing** - Optimize query performance
- [ ] **Connection Pooling** - HikariCP configuration

### Scalability
- [ ] **Docker Containerization** - Package services as containers
- [ ] **Kubernetes Deployment** - Container orchestration
- [ ] **Load Balancing** - Distribute traffic across instances

### Messaging & Events
- [ ] **Apache Kafka** - Event-driven architecture
- [ ] **RabbitMQ** - Message queue for async processing

### Monitoring & DevOps
- [ ] **Spring Boot Actuator** - Health checks and metrics
- [ ] **Prometheus + Grafana** - Application monitoring
- [ ] **ELK Stack** - Centralized logging
- [ ] **CI/CD Pipeline** - Jenkins/GitHub Actions

### Testing
- [ ] **JUnit 5** - Unit testing
- [ ] **Mockito** - Mocking framework
- [ ] **Integration Tests** - @SpringBootTest
- [ ] **API Testing** - REST Assured

### Additional Features
- [ ] **Email Notifications** - Booking confirmations
- [ ] **PDF Generation** - Ticket receipts
- [ ] **Payment Integration** - Payment gateway
- [ ] **Search Filters** - Advanced search functionality
- [ ] **API Versioning** - /v1, /v2 endpoints

---

## 👨‍💻 Author

**Suraj Kumar Shah**

*Java Backend Developer | Spring Boot Specialist*

Passionate about building scalable backend systems with clean code and best practices. This project showcases enterprise-level microservices development with modern Spring Boot technologies.

### Contact Information

- 📧 **Email:** [shahsurajkumar769@gmail.com](mailto:shahsurajkumar769@gmail.com)
- 💼 **LinkedIn:** [linkedin.com/in/suraj-kumar-shah-600155271](https://linkedin.com/in/suraj-kumar-shah-600155271)
- 🐙 **GitHub:** [@Surajshahwal](https://github.com/Surajshahwal)
- 📍 **Location:** Singrauli, Madhya Pradesh, India

### Professional Profile

- 🎓 **Education:** B.Tech in Computer Science Engineering (CGPA: 7.93/10)
- 💼 **Experience:** Java Full Stack Development Intern (4 months)
- 🛠️ **Specialization:** Backend Development, Spring Boot, REST APIs, Microservices
- 🔍 **Currently:** Open to Backend Developer opportunities

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

### MIT License Summary

Permission is hereby granted, free of charge, to any person obtaining a copy of this software to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the software, subject to copyright notice inclusion.

---

## 🙏 Acknowledgments

- Built as a demonstration of enterprise-level microservices architecture
- Developed using Spring Boot ecosystem and best practices
- Inspired by real-world train booking systems (IRCTC, MakeMyTrip)
- Thanks to the Spring community for excellent documentation and tools

---

## 📞 Support & Feedback

If you found this project helpful or have suggestions:

- ⭐ **Star this repository** on GitHub
- 🐛 **Report issues** via GitHub Issues
- 💬 **Contribute** via Pull Requests
- 📧 **Contact** for collaboration opportunities

---

## 📈 Project Stats

- **Language:** Java 17
- **Framework:** Spring Boot 3.2.0
- **Database:** MySQL 8.0
- **Architecture:** Microservices
- **Code Lines:** ~2000+ lines
- **Features:** 12+ enterprise features
- **Services:** 2 independent microservices

---

<div align="center">

### ⭐ If you found this project helpful, please give it a star! ⭐

**Made with ❤️ and ☕ by Suraj Kumar Shah**

---

**© 2026 Suraj Kumar Shah. All Rights Reserved.**

</div>
