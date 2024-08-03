# Spring Boot Code Execution API

Welcome to the Spring Boot Code Execution API project! This application provides a RESTful API that allows users to sign in, sign out, execute code, and save previously compiled code. It uses JWT authentication and Spring Security for securing endpoints, MongoDB for persisting user data and code submissions, Redis for caching, and SLF4J for logging. The project also includes JUnit tests for service layers and a global exception handler for managing errors.

# Features
User Authentication: Secure sign-in and sign-out using JWT tokens.

Code Execution: Execute code snippets by interacting with the jDoodle API.

Code Storage: Save and retrieve previously compiled code.

Caching: Improve performance with Redis caching.

Global Exception Handling: Handle exceptions globally with a custom exception handler.

Logging: Use SLF4J for logging application events and errors.

Testing: JUnit for unit testing service layers.

# Technologies Used

Java: The programming language used to build the application.

Spring Boot: Framework for building the application.

Spring Security: For securing the REST API with JWT authentication.

jDoodle API: For executing code snippets.

MongoDB: NoSQL database for storing data.

Spring Data MongoDB: For MongoDB operations.

Redis: Caching layer for performance enhancement.

Spring Data Redis: For Redis operations.

RestTemplate: For making HTTP requests to the jDoodle API.

SLF4J: For logging.

JUnit: For unit testing service layers.
