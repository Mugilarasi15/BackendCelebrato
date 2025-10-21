🎉 Celebrato – Event Management System (Backend)

This repository contains the backend of Celebrato – Event Management System, a full-stack Java Spring Boot application for managing personal and corporate events. The backend handles event inquiries, bookings, packages, and client management via a MySQL database.

🔹 Features

RESTful APIs to handle event inquiries and bookings

Admin management for events, packages, and client data

Hibernate ORM for database operations

MySQL database integration

Exception handling and validation for form submissions

🔹 Technologies Used

Backend: Java, Spring Boot, Hibernate

Database: MySQL

Build Tool: Maven

Other Tools: VS Code / IntelliJ IDEA, Postman

🔹 Project Structure
celebrato-backend/
│
├── src/
│   ├── main/java/             # Java source code (controllers, models, services)
│   └── main/resources/        # application.properties, static/config files
│
├── .mvn/wrapper/              # Maven wrapper files
├── mvnw                       # Maven wrapper scripts
├── mvnw.cmd
├── pom.xml                     # Maven dependencies
├── Dockerfile                 # Optional Docker setup
├── render.yaml                # Deployment config
└── .gitignore

🔹 Database Setup

The backend uses MySQL to store client inquiries, event bookings, and package information.

Database Connection: Configured in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/celebrato_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


⚠️ Important: This backend requires a running MySQL database. Without a live MySQL instance, APIs depending on database operations will fail.

🔹 Running Locally

Clone the repository:

git clone https://github.com/yourusername/celebrato-backend.git
cd celebrato-backend


Create MySQL Database:

CREATE DATABASE celebrato_db;


Update application.properties:

Add your MySQL username and password

Run Backend:

./mvnw spring-boot:run   # Linux/macOS
mvnw.cmd spring-boot:run  # Windows


Test APIs:

Use Postman or any API client to test endpoints like /inquiries, /bookings, /events, etc.

🔹 Deployment Note

The backend can be deployed on platforms like Render or Heroku. However, GitHub Pages cannot run Spring Boot applications and a live demo with database functionality requires a backend server connected to MySQL.
