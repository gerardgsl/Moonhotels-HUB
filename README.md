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
- **Kibana / Elasticsearch** - (if applicable) for centralized log management and visualization

### Additional Libraries
- **Lombok**: Reduces boilerplate code, primarily for getters/setters.
