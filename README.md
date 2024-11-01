# 83202115_contacts_backend


---

# Spring Boot Contacts Management API

This project is a Spring Boot RESTful API for managing Contacts, including features for adding, updating, deleting, and paginating Contacts data. This backend is designed to support a Vue.js frontend for Contacts management.

## Features

- **CRUD Operations**: Create, read, update, and delete Contacts data.
- **Batch Delete**: Supports batch deletion of Contacts.
- **Pagination**: Retrieve Contacts data with pagination and search by multiple criteria.
- **MyBatis Integration**: Uses MyBatis for data persistence with MySQL.

## Tech Stack

- **Spring Boot**: Java framework for REST API development.
- **MyBatis**: ORM framework for database interactions.
- **MySQL**: Database used for storing Contact data.
- **Lombok**: Reduces boilerplate code for model classes.

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/your-repository.git
   cd your-repository
   ```

2. **Database Setup**:
   - Create a MySQL database named `springboot-vue`.
   - Update the database configuration in `application.yml`:
     ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/springboot-vue?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8
         username: your_database_username
         password: your_database_password
     ```

3. **Build and Run**:
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```
   - Run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

4. **API Endpoints**:
   - The application will run by default on port `9090`.
   - Use `http://localhost:9090/user` as the base URL for all API calls.

## API Documentation

### Contact Endpoints

- **Add Contact**: 
  - **POST** `/user/add`
  - **Request Body**: JSON object with user details.
  
- **Update Contact**: 
  - **PUT** `/user/update`
  - **Request Body**: JSON object with updated user details.
  
- **Delete Contact**:
  - **DELETE** `/user/delete/{id}`
  - **Path Parameter**: `id` - ID of the user to delete.

- **Batch Delete Contact**:
  - **DELETE** `/user/delete/batch`
  - **Request Body**: List of user IDs to delete.

- **Get All Contact**:
  - **GET** `/user/selectAll`
  - **Returns**: List of all users.

- **Get Contact by ID**:
  - **GET** `/user/selectById/{id}`
  - **Path Parameter**: `id` - ID of the user to retrieve.

- **Search Contacts by Name**:
  - **GET** `/user/selectByName/{name}`
  - **Path Parameter**: `name` - Name to search for.
  
- **Paginated Search**:
  - **GET** `/user/selectByPage`
  - **Query Parameters**:
    - `pageNum` - Page number.
    - `pageSize` - Number of records per page.
    - `username` - Filter by username (optional).
    - `name` - Filter by name (optional).

## Project Structure

```plaintext
src
├── main
│   ├── java/com/example/springboot
│   │   ├── controller        # Controllers handling HTTP requests
│   │   ├── entity            # Entity classes representing the database schema
│   │   ├── service           # Service layer for business logic
│   │   └── mapper            # MyBatis mappers for database access
│   └── resources
│       ├── application.yml   # Configuration file for the project
└── test                      # Unit tests
```

## Key Code Components

- **Controller Layer**: Defines RESTful endpoints for Contacts management.
- **Service Layer**: Handles business logic and interacts with the database.
- **Mapper Layer**: Uses MyBatis annotations for database CRUD operations.

## Configuration

- **Port**: The application runs on port `9090` by default. Update this in `application.yml` if needed.
- **Database**: MySQL configurations are set in `application.yml`. Ensure to replace with your database credentials.

## Dependencies

- **Spring Boot Starter Web**: For building RESTful applications.
- **MyBatis**: For object-relational mapping.
- **Lombok**: For cleaner code with annotations.
- **MySQL Connector**: For MySQL database connectivity.

---

This `README.md` should provide sufficient guidance to set up, run, and interact with the API endpoints. Adjust as necessary based on your specific environment or team preferences.
