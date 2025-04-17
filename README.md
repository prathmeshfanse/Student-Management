# Student Management System - Spring Boot Application

## Table of Contents
- [Overview](#overview)
- [How to Build and Run](#how-to-build-and-run)
- [Sample API Requests](#sample-api-requests)
- [Accessing H2 Database Console](#accessing-h2-database-console)
- [API Documentation (Swagger)](#api-documentation-swagger)
- [Assumptions](#assumptions)

---

## Overview
This is a Spring Boot-based Student Management System that provides RESTful APIs to manage student data, including creating, updating, retrieving, and deleting student records.

---

## How to Build and Run

## Build the application
mvn clean install

## Run the application
mvn spring-boot:run

## The application will be accessible at:
http://localhost:8080/students/allStudents

### Prerequisites
- Java 17+  
- Maven 3.6+  
- Postman or any API testing tool (optional)

### Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/prathmeshfanse/Student-Management.git
   cd student-management-system

### Sample API Requests

Get all students 
GET /students/allStudents
 Example : http://localhost:8080/students/allStudents

Get student by ID
GET /students/{id}
 Example : http://localhost:8080/students/1

Get student by Name
GET /students?name=?
 Example : http://localhost:8080/students?name=poonam

Get student by Email
GET /students?email=?
 Example : http://localhost:8080/students?email=punam@gmail.com

Add a new student
POST /students/addStudent
 Example : http://localhost:8080/students/addStudent

Content-Type: application/json

{
    "name" : "poonam",
    "email" : "punam@gmail.com",
    "marksObtained" : 36,
    "admissionDate" : "1998-11-27"
}

Update student
PUT /students/update/{id}
 Example : http://localhost:8080/students/update/1
Content-Type: application/json

 {
    "id" : 1,
    "name": "pratik",
    "email": "pratik55@gmail.com",
    "marksObtained": 90.23,
    "admissionDate": "20221-30-11"
}

Delete student
DELETE /students/delete/{id}
 Example : http://localhost:8080/students/delete/1

### Accessing H2 Database Console

H2 console can be accessed at:
 http://localhost:8080/h2-console

Configuration in application.properties:
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=

### API Documentation (Swagger)

You can explore and test all endpoints through Swagger UI:
 http://localhost:8080/swagger-ui/index.html
 
Dependency in pom.xml:
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.1.0</version>
</dependency>

### Assumptions

Application uses in-memory H2 DB (data resets on restart).
No authentication is implemented (for now).
Validation is basic; can be enhanced.
All API responses are in JSON format.
Swagger is enabled for easier API exploration.