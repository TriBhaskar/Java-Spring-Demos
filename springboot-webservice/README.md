# Spring Boot SOAP Web Service - User Management System

## Project Overview

This is a comprehensive Spring Boot application that demonstrates the implementation of a secure SOAP web service for user management. The project showcases modern Java enterprise development practices including contract-first web services, role-based security, and RESTful CRUD operations through SOAP endpoints.

## What This Project Demonstrates

### Core Technologies & Concepts
- **Spring Boot 3.5.5** with Java 21
- **SOAP Web Services** using Spring WS
- **Contract-First Development** with XSD schema
- **Spring Security** with HTTP Basic Authentication
- **Role-Based Access Control** (RBAC)
- **JPA/Hibernate** with H2 Database
- **JAXB** for XML binding
- **Maven** for build management

### Key Features Implemented

1. **Secure SOAP Web Service**
   - Contract-first approach using XSD schema
   - WSDL generation and exposure
   - Custom SOAP security interceptor
   - HTTP Basic Authentication integration

2. **User Management Operations**
   - Create User (Admin only)
   - Get User by ID (User/Admin)
   - Get All Users (Admin only)
   - Update User (Admin only)
   - Delete User (Admin only)

3. **Security Implementation**
   - Two-tier user system: `USER` and `ADMIN` roles
   - Method-level security with `@PreAuthorize`
   - Custom security configuration
   - Password encryption with BCrypt

4. **Data Persistence**
   - JPA entities with H2 in-memory database
   - Repository pattern implementation
   - Service layer architecture

## Project Structure

```
src/
├── main/
│   ├── java/com/anterka/
│   │   ├── users/                    # Generated JAXB classes from XSD
│   │   └── webservice/
│   │       ├── SpringbootWebserviceApplication.java
│   │       ├── UserEndpoint.java     # SOAP endpoint controller
│   │       ├── SoapSecurityInterceptor.java
│   │       ├── config/
│   │       │   ├── WebServiceConfig.java      # SOAP configuration
│   │       │   ├── WebServiceSecurityConfig.java # Security setup
│   │       │   └── MethodSecurityConfig.java
│   │       ├── model/
│   │       │   └── User.java         # JPA entity
│   │       ├── repository/
│   │       │   └── UserRepository.java
│   │       └── service/
│   │           └── UserService.java
│   └── resources/
│       ├── users.xsd                 # SOAP contract definition
│       ├── application.properties
│       └── securityPolicy.xml
```

## Getting Started

### Prerequisites
- Java 21
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation & Setup

1. **Clone or download the project**
   ```bash
   cd springboot-webservice
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - WSDL: `http://localhost:8080/ws/users.wsdl`
   - SOAP Endpoint: `http://localhost:8080/ws`
   - H2 Console: `http://localhost:8080/h2-console`

### Authentication Credentials

The application comes with two pre-configured users:

| Username | Password | Role  | Permissions |
|----------|----------|-------|-------------|
| admin    | admin123 | ADMIN | All operations |
| user     | user123  | USER  | Read operations only |

## API Operations

### SOAP Operations Available

1. **getUserRequest** - Retrieve user by ID
   - **Access**: USER, ADMIN
   - **Input**: User ID
   - **Output**: User details

2. **getAllUsersRequest** - Retrieve all users
   - **Access**: ADMIN only
   - **Input**: Empty request
   - **Output**: List of all users

3. **createUserRequest** - Create new user
   - **Access**: ADMIN only
   - **Input**: firstName, lastName, email, phone
   - **Output**: Created user with generated ID

4. **updateUserRequest** - Update existing user
   - **Access**: ADMIN only
   - **Input**: Complete user object with ID
   - **Output**: Updated user details

5. **deleteUserRequest** - Delete user
   - **Access**: ADMIN only
   - **Input**: User ID
   - **Output**: Success status

### Sample SOAP Request (Create User)

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:us="http://www.anterka.com/users">
   <soapenv:Header/>
   <soapenv:Body>
      <us:createUserRequest>
         <us:firstName>John</us:firstName>
         <us:lastName>Doe</us:lastName>
         <us:email>john.doe@example.com</us:email>
         <us:phone>1234567890</us:phone>
      </us:createUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## Testing the Web Service

### Using SoapUI or Postman
1. Import the WSDL from `http://localhost:8080/ws/users.wsdl`
2. Configure Basic Authentication with admin/admin123 or user/user123
3. Send requests to `http://localhost:8080/ws`

### Using cURL
```bash
curl -X POST \
  http://localhost:8080/ws \
  -H 'Content-Type: text/xml; charset=utf-8' \
  -H 'SOAPAction: ""' \
  -u admin:admin123 \
  -d '<soapenv:Envelope>...</soapenv:Envelope>'
```

## Security Features

### Authentication
- HTTP Basic Authentication
- In-memory user details service
- BCrypt password encoding

### Authorization
- Role-based access control
- Method-level security using `@PreAuthorize`
- ADMIN role for write operations
- USER role for read operations

### Security Interceptor
- Custom SOAP security interceptor
- Request validation and user authentication logging
- Security context integration

## Database Configuration

- **Database**: H2 in-memory database
- **JPA Provider**: Hibernate
- **Entity**: User (id, firstName, lastName, email, phone)
- **Access**: H2 Console available at `/h2-console`

## Key Learning Outcomes

This project demonstrates:

1. **Contract-First Web Service Development**
   - Defining services using XSD schemas
   - Generating Java classes from XML schema
   - WSDL exposure and consumption

2. **Spring Security Integration**
   - Securing SOAP endpoints
   - Role-based authorization
   - Custom security configurations

3. **Enterprise Application Architecture**
   - Layered architecture (Controller → Service → Repository)
   - Dependency injection
   - Configuration management

4. **SOAP vs REST Understanding**
   - Protocol differences
   - When to use SOAP over REST
   - Enterprise integration patterns

## Future Enhancements

- Add database persistence with MySQL/PostgreSQL
- Implement input validation and error handling
- Add logging with SLF4J and Logback
- Create comprehensive unit and integration tests
- Add API documentation with Spring REST Docs
- Implement JWT token-based authentication

## Technologies Used

- **Spring Boot 3.5.5**
- **Spring Web Services**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **JAXB**
- **Lombok**
- **Maven**
- **Java 21**

## Author

This project was created as part of Java enterprise development learning, focusing on SOAP web services and Spring Security implementation.
