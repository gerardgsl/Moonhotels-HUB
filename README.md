# Moonhotels HUB

Moonhotels HUB is a service-oriented application developed with a clean architecture approach, incorporating **Domain-Driven Design (DDD)** and **Hexagonal Architecture** principles. This documentation provides an overview of the technologies used, instructions to start the application, access the API documentation via Swagger, and guidance on testing.

---

## Technologies, Architecture, and Libraries

### Technologies
- **Java 21** - Core programming language
- **Spring Boot 3.3.5** - Microservice framework for application setup, configuration, and dependency injection
- **JUnit** and **Mockito** - Testing framework and library for unit and integration tests.
- **Swagger** - API documentation and testing interface
- **Spring Validation**: Provides validation mechanisms to enforce business rules and data consistency.

### Architecture
- **Hexagonal Architecture**: This structure isolates the business logic from external systems (e.g., databases, APIs) through the use of ports and adapters, enhancing testability and scalability.
- **Domain-Driven Design (DDD)**: Enforces a separation of business logic from other layers and helps keep a clear domain model aligned with business requirements.
  
### Object Mapping Libraries
- **Jackson** - Manages JSON serialization and deserialization in the API
- **MapStruct** - Provides automatic mappings between Java objects, simplifying DTO and entity transformations

### Structured Logging
Utilizes a standardized logging format, improving log readability and traceability in production.
- **Logback** and **Slf4j** - For managing structured, JSON-based logs
- **Kibana** - (prepared) for centralized log management and visualization

### Additional Libraries
- **Lombok**: Reduces boilerplate code, primarily for getters/setters.

## Getting Started

### Prerequisites

- **Java 21 or later**
- **Maven** for project dependency management
- **Docker** (optional, if running via Docker)

### Running the Application Locally
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/gerardgsl/Moonhotels-HUB.git
   cd moonhotels-hub
1. **Install Dependencies**:
   Ensure all dependencies are correctly installed using Maven.
   ```bash
   mvn clean install
1. **Run the Application: Use the following command to start the application.**:
   ```bash
   mvn spring-boot:run
## Accessing Swagger API Documentation

Once the application is running, you can access the API documentation through Swagger.

Open your browser and go to: http://localhost:8080/swagger-ui.html

Swagger provides a user-friendly interface to interact with the API and explore available endpoints and request/response models.

## Testing
The application includes unit and integration tests to ensure functionality.

### Running Tests
To execute all tests, use:
1. **To execute all tests, use:**:
   ```bash
   mvn test
### Test Overview
- Unit Tests: Cover individual components using JUnit and Mockito.
- Integration Tests: Use MockMvc to simulate HTTP requests and validate API responses.

## Structured Logging
The application utilizes structured logging for effective monitoring and debugging:

- Datadog or Kibana: For monitoring and alerting.
Logs are structured and include relevant request, response, and error information to ensure traceability across services.