
---
https://developer.aliyun.com/article/1334881

# Code Style Guide

This document outlines the coding style and conventions for the Java Spring Boot project. Adhering to these guidelines helps maintain code readability, consistency, and maintainability across the project.

## 1. Project Structure

- **Packages** should follow the standard hierarchy:
  - `controller` for REST API controllers
  - `service` for business logic and service layer
  - `entity` for data models/entities
  - `mapper` for MyBatis mappers interacting with the database

## 2. Naming Conventions

### 2.1 Classes and Interfaces
- **Class Names**: Use CamelCase, and the name should clearly describe the class function, e.g., `UserController`, `UserService`.
- **Interfaces**: Should be named as nouns or adjectives, e.g., `UserService`.

### 2.2 Methods
- **Method Names**: Use camelCase and descriptive names for methods, preferring verbs to describe actions, e.g., `insertUser`, `selectByPage`.

### 2.3 Variables
- **Variables**: Use camelCase and descriptive names for variables, ensuring they reflect their purpose, e.g., `userList`, `currentPage`, `pageSize`.

### 2.4 Constants
- **Constants**: Use UPPER_CASE with underscores for readability, e.g., `DEFAULT_PAGE_SIZE`. Place constants in a separate `Constants` class if shared across multiple classes.

## 3. Code Layout and Formatting

### 3.1 Indentation and Braces
- Use **4 spaces** for indentation. Avoid tabs.
- Braces should be on the **same line** for methods and control statements:
  ```java
  if (condition) {
      // code
  } else {
      // code
  }
  ```

### 3.2 Line Length
- Limit lines to **100 characters** where possible.

### 3.3 Spacing
- Use a single space around operators (`=`, `+`, `-`, etc.).
- Use a blank line to separate logical sections of the code for readability.

### 3.4 Method Order
- Public methods should be placed before private methods within a class.
- Order methods logically to improve readability, grouping similar functionalities together.

### 3.5 Comments
- Use **Javadoc** for class and method comments, especially for public APIs.
- For other comments, use `//` for single-line comments and `/* */` for multi-line comments.
  
## 4. Annotations

- Place annotations on **separate lines** above the method or class.
- Order annotations from general to specific, e.g., `@Autowired`, `@Override`, `@GetMapping`.

Example:
```java
@Autowired
private UserService userService;

@Override
public Result updateUser(@RequestBody User user) {
    return userService.updateUser(user);
}
```

## 5. Exception Handling

- Always handle exceptions with specific messages for better debugging.
- Avoid empty `catch` blocks; log exceptions with meaningful messages.

Example:
```java
try {
    userService.insertUser(user);
} catch (Exception e) {
    logger.error("Error inserting user: " + e.getMessage());
}
```

## 6. REST API Design

- Use HTTP verbs correctly: `POST` for create, `PUT` for update, `DELETE` for delete, and `GET` for fetch.
- Ensure API paths are **RESTful** and use plural nouns, e.g., `/users` instead of `/user`.
- Place path parameters in URLs, e.g., `/user/{id}` for fetching by ID.

## 7. Transaction Management

- Ensure **transactional methods** are marked with `@Transactional`.
- For service-layer methods that include database operations, ensure proper transactional boundaries to avoid data inconsistency.

## 8. Database Interaction with MyBatis

- Prefer **XML-based mappings** or **annotations** in MyBatis to define queries.
- Use `@Param` for parameters in query methods to improve readability.

Example:
```java
@Select("SELECT * FROM user WHERE username LIKE CONCAT('%', #{username}, '%') LIMIT #{skip}, #{limit}")
List<User> selectByPage(@Param("skip") int skip, @Param("limit") int limit, @Param("username") String username);
```

## 9. Logging

- Use a logging framework like **SLF4J** for logging.
- Use different log levels (`INFO`, `DEBUG`, `ERROR`) appropriately, and avoid printing sensitive information.

Example:
```java
private static final Logger logger = LoggerFactory.getLogger(UserService.class);

logger.info("User added successfully: " + user.getId());
```

## 10. Code Reviews and Testing

- All code should go through **code review** and adhere to this style guide before being merged.
- Write **unit tests** for all service-layer methods.
- Prefer **integration tests** for controller endpoints to ensure they behave as expected.

---

