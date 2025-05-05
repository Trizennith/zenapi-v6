
# ZenAPI v6

ZenAPI v6 is a personal boilerplate project utilizing the **Spring Framework** for building scalable and well-structured RESTful APIs. This template is designed to accelerate development while maintaining best practices and consistency across Spring-based projects.

## Features

- **Scalable Project Structure**: Organized modules for better maintainability and scalability.
- **Dependency Management**: Pre-configured with essential libraries and tools for Spring-based development.
- **Exception Handling**: Standardized error responses for better API consumer experience.
- **Modular Service Layers**: Includes service, repository, and controller layers for easy code management and reusability.
- **Best Practices**: Incorporates industry standards for REST API design and development.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- PostgreSQL (or any compatible database)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Trizennith/zenapi-v6.git
   cd zenapi-v6
   ```

2. Set up your environment variables:

   - Create a `.env` file in the root directory.
   - Add database connection details and any other required variables.

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```


## Project Structure

```plaintext
zenapi-v6/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.trizennith.zenapi/
│   │   │   │   ├── controller/
│   │   │   │   ├── service/
│   │   │   │   ├── repository/
│   │   │   │   └── model/
│   │   ├── resources/
│   │   │   ├── application.yml
│   │   │   └── db/
│   └── test/
├── pom.xml
└── README.md
```

## IMPORTANT NOTE
The `application.properties` file is excluded in this commit.
