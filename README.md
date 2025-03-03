# Movies Management Application 🎬

## Overview
This project is a movie management application that allows users to manage a collection of movies, providing role-based access. It demonstrates key concepts such as Spring Dependency Injection, Client-Server Architecture, RESTful APIs, and the Layered Architecture pattern.

The application features a login system, two types of users (regular and admin), and supports CRUD (Create, Read, Update, Delete) operations for managing movies. It also incorporates Spring Security for authentication and authorization, and follows a modular and scalable architecture.

## Features

### 1. **Login System and User Roles**
The application includes a login system with two distinct user roles:
- **Regular User**: Can perform CRUD operations on movies.
- **Admin User**: Can perform CRUD operations on both movies and users.

### 2. **CRUD Operations**
- **Regular User**: Can create, read, update, and delete movies.
- **Admin User**: In addition to managing movies, admins can manage regular users by performing CRUD operations on user data.

### 3. **Spring Security Integration**
Spring Security is integrated to secure the application, ensuring that user authentication and role-based access are properly handled. Passwords are securely hashed using BCrypt.

### 4. **Database and Data Storage**
Movie and user data are stored in a relational database, with password hashing to ensure secure authentication.

---

## Architecture

This project uses the **Layered Architecture** (or **n-tier architecture**), ensuring a clear separation of concerns.

## Technologies Used
- **Spring Boot**: For backend development and REST API creation.
- **Spring Security**: For secure authentication and authorization.
- **Spring Data JPA**: For data access and persistence management.
- **Thymeleaf**: For rendering views and serving dynamic content.
- **MySQL Database**: In-memory relational database used for development.
- **Maven**: Dependency management and build automation tool.

---
  
## Implementation Details

- **Login System**: The application allows users to register, log in, and access the application based on their roles (admin or regular user).
  
- **CRUD Operations**: Both regular and admin users can create, read, update, and delete movies. Admin users also have the ability to manage regular users.

- **Spring Security**: The application ensures secure password storage and handles user authentication and authorization based on roles.

---

## Client-Server and RESTful API
The application follows a **Client-Server** architecture where the backend (server) is built using Spring Boot, serving data through **RESTful APIs**. The client interacts with these APIs to fetch and manipulate data, such as managing movies or users.

The system uses HTTP methods like GET, POST, PUT, and DELETE for CRUD operations.
