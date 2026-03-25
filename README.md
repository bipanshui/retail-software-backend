# Retail Software Backend

A RESTful backend service for retail management, built with **Spring Boot 4** and **PostgreSQL**. Provides the server-side foundation for managing retail operations such as products, inventory, and orders.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 4.0.3 |
| Web | Spring MVC (`spring-boot-starter-webmvc`) |
| Persistence | Spring Data JPA + Hibernate |
| Database | PostgreSQL |
| Utilities | Lombok |
| Monitoring | Spring Boot Actuator |
| Build Tool | Maven (Maven Wrapper included) |

---

## Prerequisites

- **Java 25+**
- **PostgreSQL** (running instance)
- **Maven 3.9+** *(or use the included `./mvnw` wrapper — no installation needed)*

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/bipanshui/retail-software-backend.git
cd retail-software-backend
```

### 2. Configure the database

Create a PostgreSQL database, then update `src/main/resources/application.properties` (or `application.yml`) with your credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/retaildb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the project

```bash
./mvnw clean install
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

The server starts on **`http://localhost:8080`** by default.

---

## Project Structure

```
retail-software-backend/
├── src/
│   ├── main/
│   │   ├── java/com/bipanshu/retailsoftware/
│   │   │   ├── controller/     # REST API controllers
│   │   │   ├── service/        # Business logic
│   │   │   ├── repository/     # Spring Data JPA repositories
│   │   │   ├── model/          # JPA entity classes
│   │   │   └── RetailsoftwareApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw / mvnw.cmd
```

---

## API Overview

The base URL for all endpoints is `http://localhost:8080`.

| Endpoint | Description |
|---|---|
| `GET /actuator/health` | Application health check |
| *(additional endpoints based on your controllers)* | |

---

## Running Tests

```bash
./mvnw test
```

Tests use the `spring-boot-starter-data-jpa-test` and `spring-boot-starter-webmvc-test` starters for integration and slice testing.

---

## Building a JAR

```bash
./mvnw clean package
java -jar target/retailsoftware-0.0.1-SNAPSHOT.jar
```

---

## Health Monitoring

Spring Boot Actuator is included. Check application health and metrics at:

```
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info
```

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## License

This project is open source. See the repository for license details.
